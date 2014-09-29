package com.basti.finance.stockmarket.presenter;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.basti.config.spring.SpringConfiguration;
import com.basti.finance.stockmarket.entities.CustomerId;
import com.basti.finance.stockmarket.entities.Stock;
import com.basti.finance.stockmarket.presenter.PortfolioPresenter;
import com.basti.finance.stockmarket.presenter.PortfolioRequest;
import com.basti.finance.stockmarket.usecase.PortfolioService;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class })
@WebAppConfiguration
public class PortfolioPresenterTest {
	
	private static final CustomerId CUSTOMERID_TEST= CustomerId.valueOf("1234");
	
	private static final Stock STOCK_TEST= new Stock("519000", "BMW", 86.148, 86.248);
	
	
    @Inject
    @InjectMocks
    private PortfolioPresenter portfolioPresenter;

    @Mock
    private PortfolioService portfolioService;

	
	@Inject
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
	}
	
	@Test 
	public void getAllStocksInAPortfolio() {
		List<Stock> dummyList = new ArrayList<>();
		dummyList.add(STOCK_TEST);
		when(portfolioService.getStocks(any(CustomerId.class))).thenReturn(
				dummyList);
		
	    given().
			log().all().
	    when().
	            get("/portfolio/{portfolioid}",CUSTOMERID_TEST.getCustomerId()).
	    then().
	    		statusCode(200).
	    		contentType(ContentType.JSON).
	            body("stocks.wkn", hasItems("519000"));
	    
		verify(portfolioService, times(1)).getStocks(any(CustomerId.class));
		verifyNoMoreInteractions(portfolioService);
	}
	
	@Test
	public void createNewPortfolioforCustomer(){
		PortfolioRequest portfolioRequest = new PortfolioRequest();
		portfolioRequest.setCustomerId(""+CUSTOMERID_TEST.getCustomerId());
		portfolioRequest.setWkn(STOCK_TEST.getWkn());
		
		given().
			log().all().
			contentType(ContentType.JSON).
			body(portfolioRequest).
        when().
        	put("/portfolio/{portfolioid}",CUSTOMERID_TEST.getCustomerId()).
        then().
			statusCode(204);
		
	}
	
	@Test
	public void deletePortfolioForCustomer() {

		given().
			log().all().
        when().
        	delete("/portfolio/{portfolioid}",CUSTOMERID_TEST.getCustomerId()).
        then().
			statusCode(204);
		
	}
}
