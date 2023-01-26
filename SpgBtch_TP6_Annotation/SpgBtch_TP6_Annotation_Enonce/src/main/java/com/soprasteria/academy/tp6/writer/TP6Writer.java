package com.soprasteria.academy.tp6.writer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;

import com.soprasteria.academy.tp6.model.TP6Livre;

public class TP6Writer implements ItemWriter<TP6Livre> {

	private String query;

	private DataSource dataSource;

	// (title, author, publicationyear, isbn, europrice, stock)
	@Override
	public void write(List<? extends TP6Livre> items) throws Exception {
		try (Connection conn = dataSource.getConnection()) {
			try (PreparedStatement pstmt = conn.prepareStatement(getQuery())) {
				for (TP6Livre element : items) {
					pstmt.setString(1, element.getTitle());
					pstmt.setString(2, element.getAuthor());
					pstmt.setInt(3, element.getPublicationYear());
					pstmt.setString(4, element.getIsbn());
					pstmt.setDouble(5, element.getEuroPrices());
					pstmt.setInt(6, element.getStock());
					pstmt.executeUpdate();
				}
				conn.commit();
			}
		}
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
}