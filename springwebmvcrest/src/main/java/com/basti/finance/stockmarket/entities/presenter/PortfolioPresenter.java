package com.basti.finance.stockmarket.entities.presenter;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.basti.finance.stockmarket.entities.CustomerId;
import com.basti.finance.stockmarket.entities.Stock;
import com.basti.finance.stockmarket.usecase.PortfolioService;

@RestController
@RequestMapping("/portfolio")
@ResponseBody
public class PortfolioPresenter {

	@Inject
	private PortfolioService portfolioService;

	/** 
	 * curl -i http://localhost:8080/simplerestservice/portfolio/?customerid=1234 
	 * **/
	@RequestMapping(value="/{portfolioid}", method = RequestMethod.GET)
	public PortfolioResponse getStockPortfolio(@PathVariable CustomerId portfolioid) {
		List<Stock> stocks = portfolioService.getStocks(portfolioid);
		return new PortfolioResponse(stocks);
	}
	
	/** 
	 * curl -i -H "Content-Type: application/json; charset=UTF-8" -X PUT -d '{"wkn":"CBK100","customerId":"123423"}'  http://localhost:8080/simplerestservice/portfolio/123423 
	 * **/
	@RequestMapping(value="/{portfolioid}",method= RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void createPortfolio(@PathVariable CustomerId portfolioid,  @RequestBody PortfolioRequest portfolioRequest) {
		System.out.println("portfolioRequest customerid: "+portfolioRequest.getCustomerId());
		System.out.println("portfolioRequest wkn: "+portfolioRequest.getWkn());
	}
	
	
	@RequestMapping(value="/{portfolioid}",method= RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePortfolio(@PathVariable CustomerId portfolioid) {
		System.out.println("portfolioRequest deleted for customer: "+portfolioid);
	}

	
	//TODO: exception handling + validation
}
