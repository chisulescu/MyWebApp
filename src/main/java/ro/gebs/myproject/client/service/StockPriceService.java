package ro.gebs.myproject.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ro.gebs.myproject.shared.stock.StockPrice;

@RemoteServiceRelativePath("stockPrices")
public interface StockPriceService extends RemoteService {

     StockPrice[] getPrices(String[] symbols) throws DelistedException;

}
