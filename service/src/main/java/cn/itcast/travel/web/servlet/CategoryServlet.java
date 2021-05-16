package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.Category;
import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.service.impl.CategoryServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet{

    private CategoryService category = new CategoryServiceImpl();

    public void findAll (HttpServletRequest req, HttpServletResponse res) throws IOException {

        List<Category> all = category.findAll();

        ResultInfo resultInfo = new ResultInfo(true);
        resultInfo.setData(all);

        writeValue(resultInfo);

    }

}
