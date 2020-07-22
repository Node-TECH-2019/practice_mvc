package practice_mvc.examples.component.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import practice_mvc.examples.component.repository.DataAccessObjectSample;
import practice_mvc.examples.entity.ProductModel;

@Controller
public class DAOSampleController {
  @Autowired
  private DataAccessObjectSample dao;

  public DAOSampleController() {
    super();
  }

  @RequestMapping(value = "/dao_sample.do", method = RequestMethod.GET)
  public ModelAndView handleRequest() {
    ProductModel productModel = this.dao.getProduct();
    String name = "examples/dao_sample";
    return new ModelAndView(name, "product", productModel);
  }
}
