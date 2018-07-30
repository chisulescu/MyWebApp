package ro.gebs.myproject.client.inregistrare.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import ro.gebs.myproject.client.login.view.LoginInterface;
import ro.gebs.myproject.client.page1.HistoryEventHandler;


public class InregistrareInterface extends Composite implements HistoryEventHandler {

    private static InregistrareInterfaceUiBinder uiBinder = GWT.create(InregistrareInterfaceUiBinder.class);
    private LoginInterface login;

    @Override
    public void handleHistory(String pageId) {

    }

    @UiTemplate("InregistrareInterface.ui.xml")
    interface InregistrareInterfaceUiBinder extends UiBinder<Widget,InregistrareInterface>{

    }

    @UiField(provided = true)
    final InregistrareInterfaceResources res;


    public InregistrareInterface(){

        this.res=GWT.create(InregistrareInterfaceResources.class);
        res.style().ensureInjected();
        initWidget(uiBinder.createAndBindUi(this));

        History.newItem("/register",false);

    }

    @UiField
    TextBox usernameBox;

    @UiField
    TextBox passwordBox;

    @UiField
    TextBox numeBox;

    @UiField
    TextBox prenumeBox;

    private Boolean tooShort = false;




    @UiHandler("buttonSubmit")
    void doClickSubmit(ClickEvent event) {
        if (!tooShort) {

            RootPanel.get().clear();
            RootPanel.get().add(login);


        } else {
            Window.alert("Parola incorecta domnuleeeeeeee!");
        }
    }

    public void setLogare(LoginInterface logare) {
        this.login = logare;
    }




}
