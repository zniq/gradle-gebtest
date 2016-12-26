/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/


import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.remote.RemoteWebDriver
import org.yaml.snakeyaml.Yaml;


waiting {
	timeout = 2
}

environments {
	
	// run via “./gradlew chromeTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		driver = { new ChromeDriver() }
	}
	
	// run via “./gradlew firefoxTest”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		/* if using Under Java7. */
		/*
		FirefoxBinary fb = new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox46\\firefox.exe"))
		def appdataPath = System.getenv('APPDATA')
		def firefoxProfileDir =  appdataPath + "\\Mozilla\\Firefox\\Profiles\\"
		FirefoxProfile fp
		new File(firefoxProfileDir).eachDirMatch(~/.+46/){
			fp = new FirefoxProfile(it)
		}

		driver = { new FirefoxDriver(fb, fp) }
		*/

		/* if using Upper Java8. */
		driver = { new FirefoxDriver() }
	}

    phantomJs {
        driver = { new PhantomJSDriver() }
    }
    ie {
		driver = { new InternetExplorerDriver() }
    }
}

waiting {
	timeout = 5
}

class AutotestSettings {
	def target = new Target()

	class Target {
		def url = ""
	}
}

def readAutotestSetting(env) {

	try {

		Yaml yaml = new Yaml();
		AutotestSettings settings = yaml.load(new FileInputStream(new File("src/test/resources/AutotestSetting_${env}.yml")))

		url = settings.target.url

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
}

readAutotestSetting("dev")
