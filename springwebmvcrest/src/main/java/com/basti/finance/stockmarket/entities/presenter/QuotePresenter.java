package com.basti.finance.stockmarket.entities.presenter;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.basti.finance.stockmarket.entities.CustomerId;
import com.basti.finance.stockmarket.entities.Stock;
import com.basti.finance.stockmarket.usecase.PortfolioService;


@RestController
@RequestMapping("/investments")
@ResponseBody
public class QuotePresenter {

	@Inject
	private PortfolioService portfolioService;

	/** curl -i http://localhost:8080/simplerestservice/portfolio/stocks?customerid=1234 **/
	@RequestMapping(value = "/stocks", method = RequestMethod.GET)
	public PortfolioResponse getStockPortfolio(
			@RequestParam(value = "customerid", required = true) CustomerId customerId) {
		List<Stock> stocks = portfolioService.getStocks(customerId);
		return new PortfolioResponse(stocks);
	}
}
