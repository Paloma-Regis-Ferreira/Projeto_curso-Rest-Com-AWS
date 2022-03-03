package br.com.paloma.data.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="books")
public class Book {
	/*`id` INT(10) AUTO_INCREMENT PRIMARY KEY,
	 * `author` longtext,
	 * `launch_date` datetime(6) NOT NULL,
	 *  `price` decimal(65,2) NOT NULL,
  	 *  `title` longtext
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "author", nullable = false, length = 180)
	private String author;
	
	@Column(name = "launch_date",nullable = false, length = 80)
	@Temporal(TemporalType.DATE)
	private Date lauchDate;

	@Column( nullable = false, length = 100)
	private Double price;

	@Column(length = 250)
	private String title;
	
	public Book() {
	}

	public Book(Long id, String author, Date lauchDate, Double price, String title) {
		super();
		this.id = id;
		this.author = author;
		this.lauchDate = lauchDate;
		this.price = price;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getLauchDate() {
		return lauchDate;
	}

	public void setLauchDate(Date lauchDate) {
		this.lauchDate = lauchDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, id, lauchDate, price, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(id, other.id)
				&& Objects.equals(lauchDate, other.lauchDate) && Objects.equals(price, other.price)
				&& Objects.equals(title, other.title);
	}

}
