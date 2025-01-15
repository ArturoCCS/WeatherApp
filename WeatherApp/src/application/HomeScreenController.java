package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.Data;
import model.MyListener;

import static utility.Format.*;
import static utility.TemperatureIconMapper.getIconForTemperature;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class HomeScreenController implements Initializable {
    @FXML
    private VBox chosenWeatherCard;

    @FXML
    private Label cityNameLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private GridPane grid;

    @FXML
    private Label humedityLabel;

    @FXML
    private Label rainLabel;

    @FXML
    private ScrollPane scroll;

    @FXML
    private Label speedLabel;

    @FXML
    private Label tempLabel;

    @FXML
    private Label temperatureUnit;

    @FXML
    private TextField txtSearch;

    @FXML
    private ImageView weatherImg;
    
    @FXML
    private Pagination pagination;
    
    @FXML
    private HBox paginationArea;

    @FXML
    private Label pageIndicator;

    @FXML
    private TextField pageInput;

    private final List<Data> dataList = new ArrayList<>();
    
    private MyListener myListener;
    
    private Image image;

    private static final int ITEMS_PER_PAGE = 24;
    private static final double CELL_WIDTH = 250.0;
    
    private int columnCount = 1;

    @FXML
    private void search(ActionEvent event) {
        String query = txtSearch.getText().toLowerCase();
        List<Data> filteredData = dataList.stream()
                .filter(data -> data.getCity().getName().toLowerCase().contains(query))
                .collect(Collectors.toList());

        if (filteredData.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sin resultados");
            alert.setHeaderText(null);
            alert.setContentText("No se encontraron datos que coincidan con '" + query + "'.");
            alert.showAndWait();
        } else {
            setupPagination(filteredData);
        }

        txtSearch.clear();
        grid.requestFocus();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    	dataList.addAll(getData());

        if (!dataList.isEmpty()) {
        	setChosenData(dataList.get(0));
            myListener = this::setChosenData;
        }
      

        setupPagination(dataList);
        setupScrollListener();
        grid.setAlignment(Pos.CENTER);

        Platform.runLater(() -> grid.requestFocus());
    }
    

  

    private void setupPagination(List<Data> dataListToShow) {
        int totalPages = (int) Math.ceil((double) dataListToShow.size() / ITEMS_PER_PAGE);
        
        pageIndicator.setText(String.valueOf(totalPages));
        HBox paginationBox = new HBox(10);
        paginationBox.setAlignment(Pos.CENTER);
        paginationBox.setPadding(new Insets(10));

        Button prevButton = new Button("Prev");
        prevButton.setDisable(true);
        prevButton.getStyleClass().add("page");
        paginationBox.getChildren().add(prevButton);

        Button nextButton = new Button("Next");
        nextButton.getStyleClass().add("page");
        paginationBox.getChildren().add(nextButton);

        updatePagination(0, totalPages, paginationBox, dataListToShow, prevButton, nextButton);
        
        pagination.setPageCount(totalPages);


        paginationArea.getChildren().clear();
        paginationArea.getChildren().add(paginationBox);
        
        
    }

    private void updatePagination(int currentPage, int totalPages, HBox paginationBox, List<Data> dataListToShow, Button prevButton, Button nextButton) {
        paginationBox.getChildren().clear();
        paginationBox.getChildren().add(prevButton);

        pageInput.setPromptText(String.valueOf(currentPage+1));
        pageInput.setOnAction(event -> {
            try {
                int pageIndex = Integer.parseInt(pageInput.getText().trim()) - 1;

                if (pageIndex >= 0 && pageIndex < totalPages) {
                    updatePagination(pageIndex, totalPages, paginationBox, dataListToShow, prevButton, nextButton);
                    createPage(scroll.getWidth(), pageIndex, dataListToShow);
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Por favor, ingresa un número válido entre 1 y " + totalPages);
                    alert.show();
                }
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor, ingresa un número válido.");
                alert.show();
            } finally {
                pageInput.clear();
                grid.requestFocus(); 
            }
        });



        
        if (totalPages <= 10) {
            for (int i = 0; i < totalPages; i++) {
                createPageButton(i, currentPage, paginationBox, dataListToShow, totalPages, prevButton, nextButton);
            }
        } else {
            if (currentPage < 4) {
                for (int i = 0; i < 3; i++) {
                    createPageButton(i, currentPage, paginationBox, dataListToShow, totalPages, prevButton, nextButton);
                }
                paginationBox.getChildren().add(createEllipsis());
                createPageButton(totalPages - 1, currentPage, paginationBox, dataListToShow, totalPages, prevButton, nextButton);
            } else if (currentPage > totalPages - 5) {
                createPageButton(0, currentPage, paginationBox, dataListToShow, totalPages, prevButton, nextButton);
                paginationBox.getChildren().add(createEllipsis());
                for (int i = totalPages - 4; i < totalPages; i++) {
                    createPageButton(i, currentPage, paginationBox, dataListToShow, totalPages, prevButton, nextButton);
                }
            } else {
                createPageButton(0, currentPage, paginationBox, dataListToShow, totalPages, prevButton, nextButton);
                paginationBox.getChildren().add(createEllipsis());
                for (int i = currentPage - 1; i <= currentPage + 1; i++) {
                    createPageButton(i, currentPage, paginationBox, dataListToShow, totalPages, prevButton, nextButton);
                }
                paginationBox.getChildren().add(createEllipsis());
                createPageButton(totalPages - 1, currentPage, paginationBox, dataListToShow, totalPages, prevButton, nextButton);
            }
        }

        paginationBox.getChildren().add(nextButton);

        prevButton.setDisable(currentPage == 0);
        nextButton.setDisable(currentPage == totalPages - 1);

        prevButton.setOnAction(event -> {
            updatePagination(currentPage - 1, totalPages, paginationBox, dataListToShow, prevButton, nextButton);
            createPage(scroll.getWidth(), currentPage - 1, dataListToShow); 
        });

        nextButton.setOnAction(event -> {
            updatePagination(currentPage + 1, totalPages, paginationBox, dataListToShow, prevButton, nextButton);
            createPage(scroll.getWidth(), currentPage + 1, dataListToShow); 
        });

        createPage(scroll.getWidth(), currentPage, dataListToShow);
    }

    private void createPageButton(int pageIndex, int currentPage, HBox paginationBox, List<Data> dataListToShow, int totalPages, Button prevButton, Button nextButton) {
        Button pageButton = new Button(String.valueOf(pageIndex + 1));

        if (pageIndex == currentPage) {
            pageButton.getStyleClass().add("selected-page");
        }else {

            pageButton.getStyleClass().add("page");
        }

        pageButton.setOnAction(event -> {
        	
            updatePagination(pageIndex, totalPages, paginationBox, dataListToShow, prevButton, nextButton);
            createPage(scroll.getWidth(), pageIndex, dataListToShow); 
        });
        paginationBox.getChildren().add(pageButton);
    }

    private Label createEllipsis() {
        Label ellipsis = new Label("...");
        ellipsis.getStyleClass().add("ellipsis");
        return ellipsis;
    }

    private void setupScrollListener() {
        scroll.widthProperty().addListener((obs, oldVal, newVal) -> {
            int newColumnCount = Math.max((int) (newVal.doubleValue() / CELL_WIDTH), 1);
            if (newColumnCount != columnCount) {
                columnCount = newColumnCount;
                createPage(newVal.doubleValue(), pagination.getCurrentPageIndex(), dataList);
            }
        });
        scroll.setFitToWidth(true);
    }


 

    private Parent createPage(double width, int pageIndex, List<Data> dataListToShow) {
        grid.getChildren().clear();

        int columnCount = Math.max((int) (width / CELL_WIDTH), 1);
        int start = pageIndex * ITEMS_PER_PAGE;
        int end = Math.min(start + ITEMS_PER_PAGE, dataListToShow.size());

        int column = 0;
        int row = 1;

        for (int i = start; i < end; i++) {
        	addDataToGrid(dataListToShow.get(i), column, row);
            column++;
            if (column == columnCount) {
                column = 0;
                row++;
            }
        }
        
        if (pageIndex == 0 && !grid.getChildren().isEmpty()) {
            Node firstItem = grid.getChildren().get(0);
            if (firstItem instanceof AnchorPane) {
                ItemController firstItemController = (ItemController) firstItem.getProperties().get("controller");
                if (firstItemController != null) {
                    firstItemController.setSelected(true);
                }
            }
        }

        centerGrid(columnCount);
        return grid;
    }

    private void addDataToGrid(Data data, int column, int row) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("item.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();

            ItemController itemController = fxmlLoader.getController();
            itemController.setData(data, myListener);
            
            anchorPane.setOnMouseClicked(event -> {
                for (Node node : grid.getChildren()) {
                    if (node instanceof AnchorPane) {
                        ItemController controller = (ItemController) ((AnchorPane) node).getProperties().get("controller");
                        controller.setSelected(false);  
                    }
                }

                itemController.setSelected(true);  
            });

            anchorPane.getProperties().put("controller", itemController);
            
            grid.add(anchorPane, column, row);
            GridPane.setMargin(anchorPane, new Insets(10));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void centerGrid(int columnCount) {
        double totalWidth = scroll.getWidth();
        double gridWidth = columnCount * CELL_WIDTH;

        double remainingSpace = totalWidth - gridWidth;
        
        grid.setPadding(remainingSpace > 0
                ? new Insets(0, remainingSpace / 2, 0, remainingSpace / 2)
                : Insets.EMPTY);
    }

    
    private void setChosenData(Data data) {
        cityNameLabel.setText(data.getCity().getName());
        dateLabel.setText(formatDate(data.getDt()));
        

        double fahrenheit = (data.getTemp().getDay() - 273.15) * 9.0 / 5.0 + 32;
		tempLabel.setText(String.format("%.2f", fahrenheit));
		temperatureUnit.setText("°F");
		
//		  Kelvin        
//        tempLabel.setText(String.format("%.2f °F", data.getTemp().getDay()))
//        double celsius = data.getTemp().getDay() - 273.15;
//        tempLabel.setText(String.format("%.2f", celsius));
//
//        temperatureUnit.setText("°K");
//        temperatureUnit.setText("°C");
		image = new Image(getClass().getResourceAsStream(getIconForTemperature(data.getTemp().getDay(), "Kelvin")));
        weatherImg.setImage(image);
        Color rgbColor = Color.rgb(255, 255, 255);  
   	    Lighting lighting = new Lighting();
   	    lighting.setLight(new Light.Distant(45, 45, rgbColor));
   	    lighting.setSurfaceScale(5.0);
   	    weatherImg.setEffect(lighting);
        speedLabel.setText(String.format("%.2f", data.getSpeed()));
        humedityLabel.setText(String.format("%.2f", data.getHumidity()));
        rainLabel.setText(String.format("%.2f", data.getRain()));
        
      

    }

    private List<Data> getData(){
    	int lines = 1049;
    	// Number of lines in the JSON file, which means there are 1049 distinct cities

    	controller.TxtParser.weatherDataToTxt(lines);
    	
    	try {
			return controller.DataParser.txtToData();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	return null;
    }
}
