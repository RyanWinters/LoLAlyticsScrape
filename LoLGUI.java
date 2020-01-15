package lolalyticsGUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;


import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoLGUI extends JFrame {
	//Note: Program would not run on another PC unless you direct line 174 to the ChromeDriver on your PC.

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoLGUI frame = new LoLGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public LoLGUI() {
		setTitle("LoLAlyticsScrape");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblFindTheWinrate = new JLabel("Find the Winrate of Any Champion");
		GridBagConstraints gbc_lblFindTheWinrate = new GridBagConstraints();
		gbc_lblFindTheWinrate.insets = new Insets(0, 0, 5, 5);
		gbc_lblFindTheWinrate.gridx = 0;
		gbc_lblFindTheWinrate.gridy = 0;
		contentPane.add(lblFindTheWinrate, gbc_lblFindTheWinrate);
		
		JLabel lblSelectChampionHere = new JLabel("Select Champion Here:");
		GridBagConstraints gbc_lblSelectChampionHere = new GridBagConstraints();
		gbc_lblSelectChampionHere.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectChampionHere.anchor = GridBagConstraints.WEST;
		gbc_lblSelectChampionHere.gridx = 0;
		gbc_lblSelectChampionHere.gridy = 2;
		contentPane.add(lblSelectChampionHere, gbc_lblSelectChampionHere);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Aatrox", "Ahri", "Akali", "Alistar", "Amumu", "Anivia", "Annie", "Aphelios", "Ashe", "Aurelion Sol", "Azir", "Bard", "Blitzcrank", "Brand", "Braum", "Caitlyn", "Camille", "Cassiopeia", "Cho'gath", "Corki", "Darius", "Diana", "Dr. Mundo", "Draven", "Ekko", "Elise", "Evelynn", "Ezreal", "Fiddlesticks", "Fiora", "Fizz", "Galio", "Gangplank", "Garen", "Gnar", "Gragas", "Graves", "Hecarim", "Heimerdinger", "Illaoi", "Irelia", "Ivern", "Janna", "Jarvan IV", "Jax", "Jayce", "Jhin", "Jinx", "Kai'sa", "Kalista", "Karma", "Karthus", "Kassadin", "Katarina", "Kayle", "Kayn", "Kennen", "Kha'zix", "Kindred", "Kled", "Kog'Maw", "LeBlanc", "Lee Sin", "Leona", "Lissandra", "Lucian", "Lulu", "Lux", "Malphite", "Malzahar", "Maokai", "Master Yi", "Miss Fortune", "Mordekaiser", "Morgana", "Nami", "Nasus", "Nautilus", "Neeko", "Nidalee", "Nocturne", "Nunu", "Olaf", "Orianna", "Ornn", "Pantheon", "Poppy", "Pyke", "Qiyana", "Quinn", "Rakan", "Rammus", "Rek'Sai", "Renekton", "Rengar", "Riven", "Rumble", "Ryze", "Sejuani", "Senna", "Sett", "Shaco", "Shen", "Shyvana", "Singed", "Sion", "Sivir", "Skarner", "Sona", "Soraka", "Swain", "Sylas", "Syndra", "Tahm Kench", "Taliyah", "Talon", "Taric", "Teemo", "Thresh", "Tristana", "Trundle", "Tryndamere", "Twisted Fate", "Twitch", "Udyr", "Urgot", "Varus", "Vayne", "Veigar", "Vel'koz", "Vi", "Viktor", "Vladimir", "Volibear", "Warwick", "Wukong", "Xayah", "Xerath", "Xin Zhao", "Yasuo", "Yorick", "Yuumi", "Zac", "Zed", "Ziggs", "Zilean", "Zoe", "Zyra"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridwidth = 7;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		contentPane.add(comboBox, gbc_comboBox);
		
		JLabel generalWR = new JLabel();
		GridBagConstraints gbc_generalWR = new GridBagConstraints();
		gbc_generalWR.gridwidth = 3;
		gbc_generalWR.insets = new Insets(0, 0, 5, 0);
		gbc_generalWR.gridx = 5;
		gbc_generalWR.gridy = 4;
		contentPane.add(generalWR, gbc_generalWR);
		
		JLabel championName = new JLabel();
		GridBagConstraints gbc_championName = new GridBagConstraints();
		gbc_championName.gridheight = 2;
		gbc_championName.insets = new Insets(0, 0, 5, 5);
		gbc_championName.gridx = 0;
		gbc_championName.gridy = 4;
		contentPane.add(championName, gbc_championName);

		
		System.setProperty("http.agent", "Chrome");
		
		JLabel redPercentages = new JLabel("");
		GridBagConstraints gbc_redPercentages = new GridBagConstraints();
		gbc_redPercentages.anchor = GridBagConstraints.EAST;
		gbc_redPercentages.insets = new Insets(0, 0, 5, 0);
		gbc_redPercentages.gridx = 7;
		gbc_redPercentages.gridy = 13;
		contentPane.add(redPercentages, gbc_redPercentages);
		JLabel imageLabel = new JLabel();
		GridBagConstraints gbc_imageLabel = new GridBagConstraints();
		gbc_imageLabel.gridheight = 6;
		gbc_imageLabel.insets = new Insets(0, 0, 5, 5);
		gbc_imageLabel.gridx = 2;
		gbc_imageLabel.gridy = 8;
		contentPane.add(imageLabel, gbc_imageLabel);
		imageLabel.setVisible(false);
		
		JLabel greenPercentages = new JLabel("");
		GridBagConstraints gbc_greenPercentages = new GridBagConstraints();
		gbc_greenPercentages.anchor = GridBagConstraints.WEST;
		gbc_greenPercentages.fill = GridBagConstraints.VERTICAL;
		gbc_greenPercentages.insets = new Insets(0, 0, 5, 5);
		gbc_greenPercentages.gridx = 1;
		gbc_greenPercentages.gridy = 13;
		contentPane.add(greenPercentages, gbc_greenPercentages);

		JLabel counterChampsLeft = new JLabel("");
		GridBagConstraints gbc_counterChampsLeft = new GridBagConstraints();
		gbc_counterChampsLeft.anchor = GridBagConstraints.WEST;
		gbc_counterChampsLeft.insets = new Insets(0, 0, 5, 5);
		gbc_counterChampsLeft.gridx = 0;
		gbc_counterChampsLeft.gridy = 13;
		contentPane.add(counterChampsLeft, gbc_counterChampsLeft);
		
		JLabel counterChampsRight = new JLabel("");
		GridBagConstraints gbc_counterChampsRight = new GridBagConstraints();
		gbc_counterChampsRight.anchor = GridBagConstraints.EAST;
		gbc_counterChampsRight.insets = new Insets(0, 0, 5, 0);
		gbc_counterChampsRight.gridx = 6;
		gbc_counterChampsRight.gridy = 13;
		contentPane.add(counterChampsRight, gbc_counterChampsRight);

		JButton btnNewButton = new JButton("Find Winrate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String champion = ((String)comboBox.getSelectedItem());
				String championCodeName = champion.replaceAll("[^a-zA-Z]","");
				
				
				// Using Selenium to find information in Javascript section of webpage
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\ryanw\\OneDrive\\Desktop\\Drivers\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
		    	options.setHeadless(true);
		    	ChromeDriver driver = new ChromeDriver(options);
		    	
		    	
		    	driver.get("https://lolalytics.com/ranked/worldwide/diamond/plus/champion/" + championCodeName + "/");
		    	WebDriverWait wait = new WebDriverWait(driver, 5);
		    	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"lol-tab-overview\"]/div/div[2]/div[1]/div[1]/div[2]/a/div")));
		    	counterChampsLeft.setText("<html>" + champion + " lane counters:<br/>" + driver.findElement(By.xpath("//*[@id=\"lol-tab-overview\"]/div/div[2]/div[1]/div[1]/div[2]/a/div")).getAttribute("data-key")
		    			+ "<br/>" + driver.findElement(By.xpath("//*[@id=\"lol-tab-overview\"]/div/div[2]/div[1]/div[1]/div[3]/a/div")).getAttribute("data-key")
		    			+ "<br/>" + driver.findElement(By.xpath("//*[@id=\"lol-tab-overview\"]/div/div[2]/div[1]/div[1]/div[4]/a/div")).getAttribute("data-key")
		    			+ "</html>");
		    	
		    	greenPercentages.setText("<html><br/>" + driver.findElement(By.xpath("//*[@id=\"lol-tab-overview\"]/div/div[2]/div[1]/div[1]/div[2]/div[1]")).getText() + "%"
		    			+ "<br/>" + driver.findElement(By.xpath("//*[@id=\"lol-tab-overview\"]/div/div[2]/div[1]/div[1]/div[3]/div[1]")).getText() + "%"
		    			+ "<br/>" + driver.findElement(By.xpath("//*[@id=\"lol-tab-overview\"]/div/div[2]/div[1]/div[1]/div[4]/div[1]")).getText() + "%");
		    	
		    	counterChampsRight.setText("<html>" + champion + " lane countered by:<br/>" + driver.findElement(By.xpath("//*[@id=\"lol-tab-overview\"]/div/div[2]/div[1]/div[2]/div[2]/a/div")).getAttribute("data-key")
		    			+ "<br/>" + driver.findElement(By.xpath("//*[@id=\"lol-tab-overview\"]/div/div[2]/div[1]/div[2]/div[3]/a/div")).getAttribute("data-key")
		    			+ "<br/>" + driver.findElement(By.xpath("//*[@id=\"lol-tab-overview\"]/div/div[2]/div[1]/div[2]/div[4]/a/div")).getAttribute("data-key")
		    			+ "</html>");
		    	
		    	redPercentages.setText("<html><br/>" + driver.findElement(By.xpath("//*[@id=\"lol-tab-overview\"]/div/div[2]/div[1]/div[2]/div[2]/div[1]")).getText() + "%"
		    			+ "<br/>" + driver.findElement(By.xpath("//*[@id=\"lol-tab-overview\"]/div/div[2]/div[1]/div[2]/div[3]/div[1]")).getText() + "%"
		    			+ "<br/>" + driver.findElement(By.xpath("//*[@id=\"lol-tab-overview\"]/div/div[2]/div[1]/div[2]/div[4]/div[1]")).getText() + "%");
		    	
		    	driver.close();
				//Adding Image to imageLabel
				Image image = null;
		        try {
		            URL url = new URL("https://cdn.lolalytics.com/image/generated/championtiles/" + championCodeName + ".jpg");
		            image = ImageIO.read(url);
		        } catch (IOException e) {
		        	e.printStackTrace();
		        }
		        imageLabel.setIcon(new ImageIcon(image));
		        imageLabel.setVisible(true);
				
				
				championName.setText(champion + "'s winrate is:");
				Document doc = null;
				try {
					doc = Jsoup.connect("https://lolalytics.com/ranked/worldwide/diamond/plus/champion/" + championCodeName + "/").get();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Elements htmlwr = doc.getElementsByClass("lanewin");
				int index = doc.getElementsByClass("lanewin").size();
				String wrate = "";
				for (String str : htmlwr.eq(index - 2).eachText()) {
					wrate = wrate + str;
				}
				generalWR.setText(wrate);
			}

		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridwidth = 8;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 3;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		
	}

}
