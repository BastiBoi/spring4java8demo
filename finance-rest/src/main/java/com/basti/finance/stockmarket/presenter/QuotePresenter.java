package com.basti.finance.stockmarket.presenter;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.basti.finance.stockmarket.entities.Stock;


@RestController
@RequestMapping("/investment")
@ResponseBody
public class QuotePresenter {


	/** curl -i http://localhost:8080/simplerestservice/portfolio/stocks?customerid=1234 **/
	@RequestMapping(value = "/stock/{stockid}", method = RequestMethod.GET)
	public Stock getStockPortfolio(@PathVariable String stockid) {
		return new Stock("519000","BMW",86.148,86.248);
	}
}
