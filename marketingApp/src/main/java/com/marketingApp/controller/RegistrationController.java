package com.marketingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingApp.dto.BlogPostDto;
import com.marketingApp.dto.RegistrationDto;
import com.marketingApp.entity.BlogPost;
import com.marketingApp.entity.Registration;
import com.marketingApp.service.BlogPostService;
import com.marketingApp.service.RegistrationService;
import com.marketingApp.util.EmailService;

@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private BlogPostService blogPostService;

	// http://localhost:8080/view

	// handler methods
	@RequestMapping("/view")
	public String viewRegistrationPage() {
		return "create_lead";
	}

//	@RequestMapping("/saveReg")
//	public String saveRegistration(@ModelAttribute Registration registration) {
//		registrationService.saveRegistration(registration);
//		return "create_lead";
//	}

//	@RequestMapping("/saveReg")
//	public String saveRegistration(
//			@RequestParam("firstName") String firstName,
//			@RequestParam("lastName") String lastName, @RequestParam("email") String email,
//			@RequestParam("mobile") long mobile
//
//	) {
//		System.out.println(registration.getId());
//		System.out.println(registration.getFirstName());
//		System.out.println(registration.getLastName());
//		System.out.println(registration.getEmail());
//		System.out.println(registration.getMobile());
//		registrationService.saveRegistration(registration);
//		System.out.println(firstName);
//		System.out.println(lastName);
//		System.out.println(email);
//		System.out.println(mobile);
//		
//		Registration reg=new Registration();
//		reg.setFirstName(firstName);
//		reg.setLastName(lastName);
//		reg.setEmail(email);
//		reg.setMobile(mobile);
//		registrationService.saveRegistration(reg);
//		return "create_lead";
//	}

	@RequestMapping("/saveReg")
	public String saveRegistration(RegistrationDto dto , Model model) {
		Registration reg = new Registration();
		reg.setFirstName(dto.getFirstName());
		reg.setLastName(dto.getLastName());
		reg.setEmail(dto.getEmail());
		reg.setMobile(dto.getMobile());
		reg.setPassword(dto.getPassword());
		
		System.out.println(100);
		registrationService.saveRegistration(reg);
		

		emailService.sendEmail(dto.getEmail(), "Welcome", "You just Sucessfully registired on our website");
		model.addAttribute("msg", "record is saved !!");
		return "List_blogs";
	}
	@RequestMapping("/getAllReg")
public String getAllRegistrations(Model model) {
		List<Registration> registrations = registrationService.getAllregistrations();
	model.addAttribute("registrations" , registrations);
		return "List_registrations";
}
	@RequestMapping("/delete")
	public String deleteLead(@RequestParam Long id, Model model) {
		registrationService.deleteLead(id);
		
		List<Registration> registrations = registrationService.getAllregistrations();
	model.addAttribute("registrations" , registrations);
		return "List_registrations";
	}
	
	@RequestMapping("/update")
	public String viewUpdatePage(@RequestParam Long id, ModelMap model) {
		Registration registration = registrationService.getRegistrationById(id);
		model.addAttribute("registration" , registration);
		return "update_lead";
	}
	@RequestMapping("/updateReg")
	public String updateRegistration(RegistrationDto dto , Model model) {
		Registration reg = new Registration();
		reg.setId(dto.getId());
		reg.setFirstName(dto.getFirstName());
		reg.setLastName(dto.getLastName());
		reg.setEmail(dto.getEmail());
		reg.setMobile(dto.getMobile());

		registrationService.saveUpdatedREgistration(reg);
		List<Registration> registrations = registrationService.getAllregistrations();
	model.addAttribute("registrations" , registrations);
		return "List_registrations";
		
	}
	
	 // Write blog post page
    @RequestMapping("/writeBlog")
    public String viewWriteBlogPage() {
        return "write_blog";
    }

    // Save blog post
    @RequestMapping("/saveBlog")
    public String saveBlogPost(BlogPostDto dto, Model model) {
        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(dto.getTitle());
        blogPost.setContent(dto.getContent());
        blogPost.setAuthor(dto.getAuthor());

        blogPostService.saveBlogPost(blogPost);

        model.addAttribute("msg", "Blog post saved successfully!");
        return "write_blog";
    }

    // Get all blog posts
    @RequestMapping("/getAllBlogs")
    public String getAllBlogPosts(Model model) {
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        model.addAttribute("blogPosts", blogPosts);
        return "List_blogs";
    }
    
    // Delete blog post
    @RequestMapping("/deleteBlog")
    public String deleteBlogPost(@RequestParam Long id, Model model) {
    	blogPostService.deleteBlogPost(id);
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        model.addAttribute("blogPosts", blogPosts);
        return "List_blogs";
    }

    // View update blog post page
    @RequestMapping("/updateBlog")
    public String viewUpdateBlogPage(@RequestParam Long id, ModelMap model) {
        BlogPost blogPost = blogPostService.getBlogPostById(id);
        model.addAttribute("blogPost", blogPost);
        return "update_blog";
    }

    // Update blog post
    @RequestMapping("/updateBlogPost")
    public String updateBlogPost(BlogPostDto dto, Model model) {
        BlogPost blogPost = new BlogPost();
        blogPost.setId(dto.getId());
        blogPost.setTitle(dto.getTitle());
        blogPost.setContent(dto.getContent());
        blogPost.setAuthor(dto.getAuthor());

        blogPostService.saveUpdatedBlogPost(blogPost);
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        model.addAttribute("blogPosts", blogPosts);
        return "List_blogs";
    }
    
    
 // Login page
    @GetMapping("/showLoginForm")
    public String showLoginForm() {
        return "Login"; // Assuming you have a login.jsp or login.html
    }

    // Handle login form submission
    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        Registration user = registrationService.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            // Login successful
            model.addAttribute("msg", "Login successful!");
            return "List_blogs";
        } else {
            // Login failed
            model.addAttribute("msg", "Invalid email or password");
            return "Login";
        }
    }

	
}
