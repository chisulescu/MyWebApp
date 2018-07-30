package ro.gebs.myproject.client.page1;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.TabPanel;

public class HomePage extends FlowPanel{
    private final Button mainButton = new Button("Main");
    private final TabPanel tabPanel = new TabPanel();
    private final String path;
    public HomePage(String path){
        this.path = path;
    }


    private int getSelectionFromToken(){
        int index = path.indexOf("/tab");
        if(index >=0){
            return Integer.parseInt(path.substring(index+"/tab".length()));
        }else{
            return 0;
        }
    }

    private String getToken(int selection) {
        int index = path.indexOf("/tab");
        if (index >= 0) {
            return path.substring(0, index) + "/tab" + selection;
        } else {
            return path + "/tab" + selection;
        }
    }

    @Override
    protected void onAttach() {

        this.setSize("1000","1000");
        super.onAttach();

        HTML firstPage = new HTML("<h1>We are on first Page.</h1>");
        HTML secondPage = new HTML("<h1>We are on second Page.</h1>");
        HTML thirdPage = new HTML("<h1>We are on third Page.</h1>");

        String firstPageTitle = "First Page";
        String secondPageTitle = "Second Page";
        String thirdPageTitle = "Third Page";


//        LoginInterface log = new LoginInterface();


        tabPanel.add(firstPage, firstPageTitle);
        tabPanel.add(secondPage, secondPageTitle);
        tabPanel.add(thirdPage, thirdPageTitle);

        tabPanel.addSelectionHandler(selectionEvent -> {
            History.newItem(getToken(selectionEvent.getSelectedItem()),false);
        });

        tabPanel.selectTab(getSelectionFromToken());

        add(tabPanel);
        add(mainButton);
    }

}
