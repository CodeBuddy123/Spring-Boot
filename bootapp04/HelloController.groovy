
@RestController
public class HelloController
{
	@RequestMapping("/hello")
	public String sayHello()
	{
		return "<h1 style='color:maroon' align='center'>Hello from Groovy app!</h1>";
	}
}