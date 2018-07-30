package ro.gebs.myproject.client.main.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.*;
import ro.gebs.myproject.client.login.view.LoginInterface;
import ro.gebs.myproject.client.page1.HistoryEventHandler;

//History improts

public class MainGUI extends Composite implements HistoryEventHandler {

//    private VerticalPanel verticalContetPanel = new VerticalPanel();
//    private TextBox textBox ;
//    private Label resultLb1;
//    MenuBar menu ;
//    MenuBar menuFile;

        private static MainGuiUiBinder uiBinder = GWT.create(MainGuiUiBinder.class);
    @Override
    public void handleHistory(String pageId) {

    }

    public void setContent(Widget w) {
        content.clear();
        content.add(w);
    }

    @UiTemplate("MainGUI.ui.xml")
    public interface MainGuiUiBinder extends UiBinder<Widget,MainGUI> {

    }

        @UiField(provided = true)
        final MainGuiResources res;


    @UiField
    MenuItem page1;

    @UiField
    MenuItem page2;

    @UiField
    MenuItem login;

    @UiField
    MenuBar menuBar;

    @UiField
    MenuItem aboutMenuItem;

    @UiField
    MenuItem siteMapMenuItem;

    @UiField
    HTMLPanel homePanel;

    @UiField
    FlowPanel content;


    public  MainGUI(){

        this.res=GWT.create(MainGuiResources.class);
        res.style().ensureInjected();
        initWidget(uiBinder.createAndBindUi(this));
        login.setScheduledCommand(new Command() {
            @Override
            public void execute() {
                History.newItem("/login",true);
            }
        });
        page1.setScheduledCommand(new Command() {
            @Override
            public void execute() {
                History.newItem("/page1",true);
            }
        });

        page2.setScheduledCommand(new Command() {
            @Override
            public void execute() {
                History.newItem("/page2", true);
            }
        });

    }

 }

