package camera;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.sarxos.webcam.Webcam;

@Controller
public class CameraController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping(value="/showPic")
	public String showPic() throws IOException {
//		BufferedImage image = takeImage();
//		ByteArrayOutputStream byteArrayOS=new ByteArrayOutputStream();
//		ImageIO.write(image, "jpg", byteArrayOS);
//		byte [] byteArray=byteArrayOS.toByteArray();
//		
//		model.addAttribute("checker", "Just checking");
//		model.addAttribute("image", image.getData());
//		
		return "pic";
	}
	
	@GetMapping(value="/getPic", produces = "image/jpg")
	public @ResponseBody byte[] getPic() throws IOException {
		BufferedImage image = takeImage();
		ByteArrayOutputStream byteArrayOS=new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", byteArrayOS);
		byte [] byteArray=byteArrayOS.toByteArray();
		
		return byteArray;
	}
	
	public BufferedImage takeImage() {
		Webcam webcam = Webcam.getDefault();
		webcam.open();
		BufferedImage image = webcam.getImage();
		webcam.close();
		
		return image;
	}
}
