package ro.gebs.myproject.client.start;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import ro.gebs.myproject.client.inregistrare.view.InregistrareInterface;
import ro.gebs.myproject.client.login.view.LoginInterface;
import ro.gebs.myproject.client.main.view.MainGUI;
import ro.gebs.myproject.client.page1.HomePage;
import ro.gebs.myproject.client.service.StockPriceService;
import ro.gebs.myproject.client.service.StockPriceServiceAsync;
import ro.gebs.myproject.client.stock.view.StockWatcher;
import ro.gebs.myproject.shared.stock.StockPrice;

import java.util.ArrayList;


public class MyProject implements EntryPoint {

    //    private SplitLayoutPanel splitLayoutPanel = new SplitLayoutPanel();
//
//
//    private MainGUI mainGUI = new MainGUI();
//





    public static final int REFRESH_INTERVAL=5000; // in milisecunde
    private VerticalPanel mainPanel = new VerticalPanel();
    private FlexTable stocksFlexTable = new FlexTable();
    private HorizontalPanel addPanel = new HorizontalPanel();
    private TextBox newSymbolTextBox = new TextBox();
    private Button addStockButton = new Button("Add");
    private Button addButtonParieaza = new Button("Parieaza");
    private Label lastUpdatedLabel = new Label();
    private ArrayList<String> stocks = new ArrayList<String>();
    private TabLayoutPanel p = new TabLayoutPanel(1.5, Style.Unit.EM);
    private DockLayoutPanel appPanel = new DockLayoutPanel(Style.Unit.EM);
    private StockPriceServiceAsync stockPriceSvc = GWT.create(StockPriceService.class);
    private Label errorMsgLabel = new Label();

















    public void onModuleLoad() {



        StockPrice price = new StockPrice("^%^%^%",11,11);


        Button removeStockButton = new Button("x");

        removeStockButton.addStyleDependentName("remove");
        addButtonParieaza.setSize("1000","1500");


        stocksFlexTable.setText(0, 0, "Symbol");
        stocksFlexTable.setText(0, 1, "Price");
        stocksFlexTable.setText(0, 2, "Change");
        stocksFlexTable.setText(0, 3, "Remove");

        stocksFlexTable.setCellPadding(6);

        // Assemble Add stock panel.
        addPanel.add(newSymbolTextBox);
        addPanel.add(addStockButton);


        // Assemble Main panel.
        mainPanel.add(stocksFlexTable);
        mainPanel.add(addPanel);
        mainPanel.add(lastUpdatedLabel);

        //  mainPanel.add(p);


        addPanel.add(newSymbolTextBox);
        addPanel.add(addStockButton);
        addPanel.add(addButtonParieaza);
        addPanel.addStyleName("addPanel");


        //adaugam elementele de stil din fisierul css in taabel
        stocksFlexTable.getRowFormatter().addStyleName(0, "watchListHeader"); // aici accesam fiecare rand in parte si adauga stilul(italic)
        stocksFlexTable.addStyleName("watchList");//aici stabilim stilul pentru lista de bani care va fi afisata
        stocksFlexTable.getCellFormatter().addStyleName(0, 1, "watchListNumericColumn");
        stocksFlexTable.getCellFormatter().addStyleName(0, 2, "watchListNumericColumn");
        stocksFlexTable.getCellFormatter().addStyleName(0, 3, "watchListRemoveColumn");

        // Associate the Main panel with the HTML host page.

        RootPanel.get().add(mainPanel);


        // Move cursor focus to the input box.
        newSymbolTextBox.setFocus(true);

        // Listen pentru eventuri de la mouse

        addStockButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                addStock();
            }
        });

        addButtonParieaza.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                addWidget();
            }
        });


        //listener pentru eventuri de la tastatura
        newSymbolTextBox.addKeyDownHandler(new KeyDownHandler() {
            public void onKeyDown(KeyDownEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                    addStock();
                }
            }
        });

        newSymbolTextBox.setFocus(true);


        //refresh automat pentru date
        Timer refreshTimer = new Timer() {
            @Override
            public void run() {
                refreshWatchList();
            }
        };

        refreshTimer.scheduleRepeating(REFRESH_INTERVAL);

















//        handleHistory(History.getToken());
//
//        History.addValueChangeHandler(new ValueChangeHandler<String>() {
//                public void onValueChange(ValueChangeEvent<String> event) {
//                    String historyToken = event.getValue();
//                    handleHistory(historyToken);
//                }
//            });
//
//
//
//
//        RootPanel.get().add(mainGUI);

//        StockWatcher stock = new StockWatcher();
//        RootPanel.get().add(stock);


//        PersonPresenter.Display display = new PersonView();
//        user user = new user("ionescu","1234","Ionescu","George");
//        Presenter presenter = new PersonPresenter(user,display);
//
//        presenter.go(RootPanel.get());

//        final SimpleEventBus eventBus = new SimpleEventBus();
//        final Label el = new Label();
//        final Label el2 = new Label();
//        final Button btn = new Button("Make an offert");
//        String mesaj1 = "Salut numlee meu este ioan";
//        String mesaj2 = "Salut numlee meu este Ionut";
//        String mesaj3 = "Salut !!!!!!!!!!!!!!!";
//        String mesaj4 = "Salutare lume";
//
//
//        el.setText(mesaj1);
//        el2.setText(mesaj1);
//        RootPanel.get().add(el);
//        RootPanel.get().add(el2);
//        RootPanel.get().add(btn);
//
//        eventBus.addHandler(DeclineEvent.TYPE, new DeclineEventHandler() {
//            @Override
//            public void OnInOut(DeclineEvent event) {
//                el.setText(mesaj3);
//            }
//        });
//
//        eventBus.addHandler(DeclineEvent.TYPE, new DeclineEventHandler() {
//            @Override
//            public void OnInOut(DeclineEvent event) {
//                el2.setText(mesaj2);
//            }
//        });
//
//
//        btn.addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent clickEvent) {
//                eventBus.fireEvent(new DeclineEvent());
//            }
//        });


//        final TextArea output = new TextArea();
//        output.setSize("400px","200px");
//
//        String url = "http://gdata.youtube.com/feeds/api/videos?"
//                + "author=DisturbedTV"
//                + "&max-result=5"
//                + "&orderby=published"
//                + "&v=2&alt=json";
//
//        JsonpRequestBuilder rb = new JsonpRequestBuilder();
//        rb.requestObject(url, new AsyncCallback<Feed>() {
//
//
//            @Override
//            public void onFailure(Throwable throwable) {
//                output.setText("Eroare");
//
//            }
//
//            @Override
//            public void onSuccess(Feed jso) {
//                printData(output,jso);
//            }
//
//        });


    }

//    private void handleHistory(String historyToken) {
//
//        if(historyToken!=null){
//            if(historyToken.startsWith("/login")){
//                mainGUI.setContent(new LoginInterface());
//            }else if(historyToken.startsWith("/page1")){
//                mainGUI.setContent(new HomePage(historyToken));
//            }else if(historyToken.startsWith("/page2")){
//                mainGUI.setContent(new InregistrareInterface());
//            }
//        }else{
//            mainGUI.setContent(new LoginInterface());
//        }
//    }

//    private void printData(TextArea output, Feed feed){
//        for(int i=0;  i < feed.entryCount(); i++){
//            output.setText(output.getText() + feed.getEntry(1).getTitle() + "\n");
//        }
//
//    }


//    protected void initWindowClosingConfirmationDialog() {
//        Window.addWindowClosingHandler(new Window.ClosingHandler() {
//            @Override
//            public void onWindowClosing(Window.ClosingEvent event) {
//                // This message doesn't show, but by adding this close handler,
//                // we get the default dialog to display and confirm that the
//                // user does want to leave our site.
//                event.setMessage("Are you sure you want to leave?");
//            }
//        });
//    }
//
//    public void setUpHistoryManagement(){
//        // Make this class your history manager (see onValueChange method)
//        History.addValueChangeHandler((ValueChangeHandler<String>) this);
//        // Handle any existing history token
//        History.fireCurrentHistoryState();
//        // Trap user hitting back button too many times.
//        Window.addWindowClosingHandler(new Window.ClosingHandler(){
//            public void onWindowClosing(Window.ClosingEvent event) {
//                event.setMessage("Ran out of history.  Now leaving application, is that OK?");
//            }
//        });
//    }






    private void addWidget(){

        // appPanel.add(p);
        p.add(new HTML("this content"), "this");
        p.add(new HTML("that content"), "that");
        p.add(new HTML("the other content"), "the other");
        RootPanel.get().add(p);

    }



    private void addStock(){

        final String symbol = newSymbolTextBox.getText().toUpperCase().trim();
        newSymbolTextBox.setFocus(true);


        if (!symbol.matches("^[0-9A-Z\\.]{1,10}$")) {
            Window.alert("'" + symbol + "' is not a valid symbol.");
            newSymbolTextBox.selectAll();
            return;
        }


        newSymbolTextBox.setText("");

        if (stocks.contains(symbol))
            return;

        int row = stocksFlexTable.getRowCount();
        stocks.add(symbol);
        stocksFlexTable.setText(row, 0, symbol);

        stocksFlexTable.setWidget(row, 2, new Label());
        stocksFlexTable.getCellFormatter().addStyleName(row, 1, "watchListNumericColumn");
        stocksFlexTable.getCellFormatter().addStyleName(row, 2, "watchListNumericColumn");
        stocksFlexTable.getCellFormatter().addStyleName(row, 3, "watchListRemoveColumn");


        //metoda pentru remove
        Button removeStockButton = new Button("x");
        removeStockButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                int removedIndex = stocks.indexOf(symbol);
                stocks.remove(removedIndex);
                stocksFlexTable.removeRow(removedIndex + 1);
            }
        });
        stocksFlexTable.setWidget(row, 3, removeStockButton);

        refreshWatchList();

    }

    //la fiecare interval de timp parcurgem toate stock-urile, le facem update si apoi refresh sa se vada in UI
//    private void refreshWatchList() {
//        // Initialize the service proxy.
//
//        StockPriceServiceAsync stockPriceServiceAsync = StockPriceServiceAsync.Util.getInstance();
//
//        if (stockPriceSvc == null) {
//            stockPriceSvc = GWT.create(StockPriceService.class);
//        }
////        if (stockPriceServiceAsync == null) {
////            stockPriceServiceAsync = StockPriceServiceAsync.Util.getInstance();
////        }
//
//
//
//
//        // Set up the callback object.
//        AsyncCallback<StockPrice[]> callback = new AsyncCallback<StockPrice[]>() {
//            public void onFailure(Throwable caught) {
//                caught.printStackTrace();
//            }
//
//            public void onSuccess(StockPrice[] result) {
//                updateTable(result);
//            }
//        };
//
//        // Make the call to the stock price service.
//        stockPriceServiceAsync.getPrices(stocks.toArray(new String[0]), callback);
//    }


    private void refreshWatchList() {
        final double MAX_PRICE = 100.0; // $100.00f
        final double MAX_PRICE_CHANGE = 0.02; // +/- 2%

        StockPrice[] prices = new StockPrice[stocks.size()];
        for (int i = 0; i < stocks.size(); i++) {
            double price = Random.nextDouble() * MAX_PRICE;
            double change = price * MAX_PRICE_CHANGE * (Random.nextDouble() * 2.0 - 1.0);

            prices[i] = new StockPrice(stocks.get(i), price, change);
        }

        updateTable(prices);
    }


    //parcurgem fiecare stok si ii facem update
    private void updateTable(StockPrice[] prices) {

        for (int i = 0; i < prices.length; i++) {
            updateTable(prices[i]);
        }
    }

    private void updateTable(StockPrice price) {
        // Make sure the stock is still in the stock table.
        if (!stocks.contains(price.getSymbol())) {
            return;
        }

        int row = stocks.indexOf(price.getSymbol()) + 1;

        // Format the data in the Price and Change fields.
        String priceText = NumberFormat.getFormat("#,##0.00").format(price.getPrice());
        NumberFormat changeFormat = NumberFormat.getFormat("+#,##0.00;-#,##0.00");
        String changeText = changeFormat.format(price.getChange());
        String changePercentText = changeFormat.format(price.getChangePercent());

        // Populate the Price and Change fields with new data.
        stocksFlexTable.setText(row, 1, priceText);

        stocksFlexTable.setText(row, 2, changeText + " (" + changePercentText + "%)");

        Label changeWidget = (Label)stocksFlexTable.getWidget(row, 2);
        changeWidget.setText(changeText + " (" + changePercentText + "%)");

        String changeStyleName  = "noChange";

        if(price.getChangePercent() < -0.1f){
            changeStyleName = "negativeChange";
        }
        else if (price.getChangePercent() > 0.1f){
            changeStyleName ="positiveChange";
        }

        changeWidget.setStyleName(changeStyleName);

    }







}