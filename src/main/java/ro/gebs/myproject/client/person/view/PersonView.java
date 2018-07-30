package ro.gebs.myproject.client.person.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import ro.gebs.myproject.client.person.presenter.PersonPresenter;

public class PersonView extends Composite implements PersonPresenter.Display {


    private static PersonViewUiBinder uiBinder = GWT.create(PersonViewUiBinder.class);
    private PersonPresenter personPresenter;



    @UiTemplate("Person.ui.xml")
    interface PersonViewUiBinder extends UiBinder<Widget,PersonView>{

    }

    @UiField(provided = true)
    final PersonResources res;

    public PersonView(){
        this.res = GWT.create(PersonResources.class);
        res.style().ensureInjected();
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiField
    Label nume;

    @UiHandler("buttonNume")
    void doClickSubmit(ClickEvent event) {

        if(personPresenter != null){
            personPresenter.showFullName();
        }
    }


    @UiHandler("buttonSterge")
    void doClickClear(ClickEvent event) {

        personPresenter.clearDisplay();
    }

    @Override
    public void clear() {

        nume.setText("");
    }

    @Override
    public void setName(String name) {

        this.nume.setText(name);
    }

    @Override
    public void setPresenter(PersonPresenter presenter) {

        this.personPresenter = presenter;
    }




}
