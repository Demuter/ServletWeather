package weather;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Formatter;

public class LoadParseXML {
	String cityName = "Minsk";
	String apiKEY = "5f5a74ab4613cbba931a4669d212b993";
	Formatter siteWeb = new Formatter();

	public void load(String city) {
		try {
			siteWeb.format("http://api.openweathermap.org/data/2.5/weather?q=%s&mode=xml&units=metric&appid=%s", city,
					apiKEY);
			URL webSite = new URL(siteWeb.toString());
			ReadableByteChannel rbc = Channels.newChannel(webSite.openStream());
			FileOutputStream fos = new FileOutputStream("weather.xml");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String parseCityName() {
		String tmp = "";
		try {
			File file = new File("weather.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);
			document.getDocumentElement().normalize();

			NodeList nodeList1 = document.getElementsByTagName("city");

			for (int i = 0; i < nodeList1.getLength(); i++) {
				Node node = nodeList1.item(i);
				if (Node.ELEMENT_NODE == node.getNodeType()) {
					Element element = (Element) node;
					tmp = "City: " + element.getAttribute("name");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return tmp;
	}

	public String parseTemperature() {
		String tmp = "";
		try {
			File file = new File("weather.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);
			document.getDocumentElement().normalize();

			NodeList nodeList2 = document.getElementsByTagName("temperature");
			for (int i = 0; i < nodeList2.getLength(); i++) {
				Node node = nodeList2.item(i);
				if (Node.ELEMENT_NODE == node.getNodeType()) {
					Element element = (Element) node;
					tmp = "Temperature: " + element.getAttribute("value") + "°C";
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return tmp;
	}

	public String parseHumidity() {
		String tmp = "";
		try {
			File file = new File("weather.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);
			document.getDocumentElement().normalize();

			NodeList nodeList3 = document.getElementsByTagName("humidity");
			for (int i = 0; i < nodeList3.getLength(); i++) {
				Node node = nodeList3.item(i);
				if (Node.ELEMENT_NODE == node.getNodeType()) {
					Element element = (Element) node;
					tmp = "Humidity: " + element.getAttribute("value") + "%";
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return tmp;
	}

	public String parsePressure() {
		String tmp = "";
		try {
			File file = new File("weather.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);
			document.getDocumentElement().normalize();

			NodeList nodeList4 = document.getElementsByTagName("pressure");
			for (int i = 0; i < nodeList4.getLength(); i++) {
				Node node = nodeList4.item(i);
				if (Node.ELEMENT_NODE == node.getNodeType()) {
					Element element = (Element) node;
					tmp = "Pressure: " + element.getAttribute("value") + " hPa";
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return tmp;
	}

	public String parseClouds() {
		String tmp = "";
		try {
			File file = new File("weather.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);
			document.getDocumentElement().normalize();

			NodeList nodeList5 = document.getElementsByTagName("clouds");
			for (int i = 0; i < nodeList5.getLength(); i++) {
				Node node = nodeList5.item(i);
				if (Node.ELEMENT_NODE == node.getNodeType()) {
					Element element = (Element) node;
					tmp = "Clouds: " + element.getAttribute("name");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return tmp;
	}

	public void parseXML() {
		 java.util.Date date = new java.util.Date();
		 System.out.println(date.toString());
		try {
			File file = new File("weather.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file);
			document.getDocumentElement().normalize();

			NodeList nodeList1 = document.getElementsByTagName("city");
			for (int i = 0; i < nodeList1.getLength(); i++) {
				Node node = nodeList1.item(i);
				if (Node.ELEMENT_NODE == node.getNodeType()) {
					Element element = (Element) node;
					System.out.println("City: " + element.getAttribute("name"));
				}
			}

			NodeList nodeList2 = document.getElementsByTagName("temperature");
			for (int i = 0; i < nodeList2.getLength(); i++) {
				Node node = nodeList2.item(i);
				if (Node.ELEMENT_NODE == node.getNodeType()) {
					Element element = (Element) node;
					System.out.println("Temperature: " + element.getAttribute("value") + "°C");
				}
			}

			NodeList nodeList3 = document.getElementsByTagName("humidity");
			for (int i = 0; i < nodeList3.getLength(); i++) {
				Node node = nodeList3.item(i);
				if (Node.ELEMENT_NODE == node.getNodeType()) {
					Element element = (Element) node;
					System.out.println("Humidity: " + element.getAttribute("value") + "%");
				}
			}

			NodeList nodeList4 = document.getElementsByTagName("pressure");
			for (int i = 0; i < nodeList4.getLength(); i++) {
				Node node = nodeList4.item(i);
				if (Node.ELEMENT_NODE == node.getNodeType()) {
					Element element = (Element) node;
					System.out.println("Pressure: " + element.getAttribute("value") + " hPa");
				}
			}

			NodeList nodeList5 = document.getElementsByTagName("clouds");
			for (int i = 0; i < nodeList5.getLength(); i++) {
				Node node = nodeList5.item(i);
				if (Node.ELEMENT_NODE == node.getNodeType()) {
					Element element = (Element) node;
					System.out.println("Clouds: " + element.getAttribute("name"));
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
}
