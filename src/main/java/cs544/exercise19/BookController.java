package cs544.exercise19;

/**
 * User: franc
 * Date: 17/09/2018
 * Time: 1:50
 */

import javax.annotation.Resource;

import cs544.sample.Car;
import cs544.sample.ICarDao;
import cs544.sample.NoSuchResourceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class BookController {
    @Resource
    private IBookDao bookDao;



    @RequestMapping(value="/books", method=RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("books", bookDao.getAll());
        return "bookList";
    }

    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String add(Book car) {
        bookDao.add(car);
        return "redirect:/books";
    }

    @RequestMapping(value="/books/{id}", method=RequestMethod.GET)
    public String get(@PathVariable int id, Model model)
    {
        model.addAttribute("book", bookDao.get(id));
        return "bookDetail";
    }

    @RequestMapping(value="/books/add", method=RequestMethod.GET)
    public String get( Model model)
    {
        model.addAttribute("book", null );
        return "bookDetail";
    }

    @RequestMapping(value="/books/{id}", method=RequestMethod.POST)
    public String update(Book car, @PathVariable int id) {
        bookDao.update(id, car); // car.id already set by binding
        return "redirect:/books";
    }
    @RequestMapping(value="/books/", method=RequestMethod.POST)
    public String update(Book car) {
        bookDao.add(car); // car.id already set by binding
        return "redirect:/books";
    }

    @RequestMapping(value="/books/delete", method=RequestMethod.POST)
    public String delete(int carId) {
        bookDao.delete(carId);
        return "redirect:/books";
    }


    @ExceptionHandler(value= NoSuchResourceException.class)
    public ModelAndView handle(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.getModel().put("e", e);
        mv.setViewName("noSuchResource");
        return mv;
    }
}
