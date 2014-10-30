package Ex13_TwitterClient.org;

public class MyItem {
	String icon, scrren, name, text, time;

	public MyItem(String icon, String scrren, String name, String text,
			String time) {
		this.icon = icon;
		this.scrren = scrren;
		this.name = name;
		this.text = text;
		this.time = time;
	}

	MyItem(MyItem obj) {
		this.icon = obj.icon;
		this.scrren = obj.scrren;
		this.name = obj.name;
		this.text = obj.text;
		this.time = obj.time;
	}

	MyItem() {

	}

}
