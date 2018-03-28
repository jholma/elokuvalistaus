package swd.harjoitustyo1.ElokuvaListaus.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swd.harjoitustyo1.ElokuvaListaus.domain.GenreRepository;
import swd.harjoitustyo1.ElokuvaListaus.domain.Movie;
import swd.harjoitustyo1.ElokuvaListaus.domain.MovieRepository;

@Controller
public class MovieController {
	
	@Autowired
	private MovieRepository mrepository;
	
	@Autowired
	private GenreRepository grepository;
	
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}
	
    @RequestMapping(value="/movielistaus")
    public String MovieList(Model model) {	
        model.addAttribute("movies", mrepository.findAll());
        return "movielistaus";
    }

    @RequestMapping(value = "/movieEdit", method = RequestMethod.POST)
    public String save(Movie movie, Model model){
        mrepository.save(movie);
        return "redirect:movielistaus";
    }
    
    //edit movie comment, just comment part 1
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String addComment(Model model, @PathVariable("id") Long movieId){
    	//Movie movie = new Movie();
    	model.addAttribute("movie", mrepository.findById(movieId));
        return "editcomment";
    } 
    // post-method from html-template to save only comment-atribute part2
    @RequestMapping(value = "/saveedit", method=RequestMethod.POST)
    public String updateCommentByMovieId(@ModelAttribute Movie movie) {
    	mrepository.save(movie);
      return "redirect:movielistaus";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long movieId, Model model) {
    	mrepository.deleteById(movieId);
        return "redirect:../movielistaus";
    }
    
    @RequestMapping(value = "/addmovie")
    public String addBook(Model model){
    	model.addAttribute("movie", new Movie());
    	model.addAttribute("genres", grepository.findAll());
        return "addmovie";
    } 
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Movie movie){
        mrepository.save(movie);
        return "redirect:movielistaus";
    }  
    
}