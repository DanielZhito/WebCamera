package test;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.junit.Test;

import com.github.sarxos.webcam.Webcam;

public class WebcamTest {

	@Test
	public void checkCamera() {
		Webcam webcam = Webcam.getDefault();
		webcam.open();
		
		File picFile = new File("hello-world.jpg");
		if(picFile.exists()) {
			if(picFile.delete()) {
				System.out.println("Deleted picFile");
			}
			else {
				System.out.println("Error: Couldn't delete file");
			}
		}
		
		try {
			ImageIO.write(webcam.getImage(), "JPG", picFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertTrue(picFile.exists());
	}
}
