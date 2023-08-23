package com.jdbc.demo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Optional;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import com.jdbc.demo.model.BooksModel;
import com.jdbc.demo.model.Response;
import com.jdbc.demo.model.libraryModel;
import com.jdbc.demo.service.LibraryService;

@SuppressWarnings("unused")
@Component
public class LibraryDao implements LibraryService {

	Response res = new Response();

	String url = "jdbc:mysql://127.0.0.1:3306/kgm";
	String username = "root";
	String password = "Arvindh@2000";

	@Override
	public Response createUser(libraryModel values) {

		String uuid = UUID.randomUUID().toString();
		values.setmemberID(uuid);
		values.setCreatedBy(uuid);
		values.setUpdateBy(uuid);

		Date date = new Date(Calendar.getInstance().getTime().getTime());
		values.setCreatedTime(date);
		values.setUpdatedTime(date);

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement();) {

				String insertQuery = "INSERT into library.librarymembers(MemberID,FirstName,LastName,DateOfBirth,Address,Email,PhoneNumber,created_by,updated_by,created_time,updated_time,password)"
						+ "VALUES('" + values.getmemberID() + "', '" + values.getFirstName() + "' , '"
						+ values.getLastName() + "' , '" + values.getDob() + "' , '" + values.getAddress() + "', " + "'"
						+ values.getEmail() + "' , '" + values.getPhoneNumber() + "' , '" + values.getCreatedBy()
						+ "' , '" + values.getUpdateBy() + "' , '" + values.getCreatedTime() + "' , '"
						+ values.getCreatedTime() + "' ," + "'" + values.getPassword() + "')";

				st.executeUpdate(insertQuery);

				res.setData("User Created Successfully!");
				res.setResponseCode(200);
				res.setResponseMessage("Success");

			} catch (Exception e) {
				e.printStackTrace();

				res.setData("Cannot create User!");
				res.setResponseCode(500);
				res.setResponseMessage("Error");

			}

		} catch (Exception e) {
			e.printStackTrace();

			res.setData("Driver Class Error");
			res.setResponseCode(500);
			res.setResponseMessage("Error");

		}

		return res;

	}

	@Override
	public Response insertBooks(BooksModel values) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement();) {

				String insertQuery1 = "INSERT into library.librarybooks(ISBN,Title,Author,PublicationYear,Genre,AvailableCopies,TotalCopies)"

						+ "VALUES('" + values.getIsbn() + "' , '" + values.getTitle() + "' , '" + values.getAuthor()
						+ "' , '" + values.getPublicationYear() + "'" + " , '" + values.getGenre() + "' , '"
						+ values.getAvailableCopies() + "' , '" + values.getTotalCopies() + "')";

				st.executeUpdate(insertQuery1);

				res.setData("Inserted Successfully!");
				res.setResponseCode(200);
				res.setResponseMessage("Success");

			} catch (Exception e) {

				e.printStackTrace();

				res.setData("Cannot Insert!");
				res.setResponseCode(500);
				res.setResponseMessage("Error");
			}

		} catch (Exception e) {

			e.printStackTrace();

			res.setData("Driver Class Error !");
			res.setResponseCode(500);
			res.setResponseMessage("Error");

		}

		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Response getAllUser() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String SelectQuery = "select * from librarymembers";

			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(SelectQuery);) {

				JSONArray jsonArray = new JSONArray();

				while (rs.next()) {
					JSONObject jsonobject = new JSONObject();
					jsonobject.put("memberID", rs.getString("MemberID"));
					jsonobject.put("firstName", rs.getString("FirstName"));
					jsonobject.put("lastName", rs.getString("LastName"));
					jsonobject.put("dob", rs.getDate("DateOfBirth"));
					jsonobject.put("address", rs.getString("Address"));
					jsonobject.put("email", rs.getString("Email"));
					jsonobject.put("phoneNumber", rs.getLong("PhoneNumber"));
					jsonobject.put("createdBy", rs.getLong("created_by"));
					jsonobject.put("updateBy", rs.getLong("updated_by"));
					jsonobject.put("createdTime", rs.getLong("created_time"));
					jsonobject.put("updatedTime", rs.getLong("updated_time"));
					jsonobject.put("password", rs.getLong("password"));

					jsonArray.add(jsonobject);
				}

				res.setData("Users Fetched Successfully!");
				res.setResponseCode(200);
				res.setResponseMessage("Success");
				res.setjData(jsonArray);

			} catch (Exception e) {
				e.printStackTrace();

				res.setData("Cannot Fetch User!");
				res.setResponseCode(500);
				res.setResponseMessage("Error");
			}

		} catch (Exception e) {
			e.printStackTrace();

			res.setData("Driver Class Error!");
			res.setResponseCode(500);
			res.setResponseMessage("Error");

		}

		return res;
	}

	@SuppressWarnings("unchecked")
	public Response getAllBooks() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String SelectQuery1 = "select * from librarybooks";

			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(SelectQuery1);) {

				JSONArray jsonArray = new JSONArray();

				while (rs.next()) {
					JSONObject jsonobject = new JSONObject();
					jsonobject.put("isbn", rs.getString("ISBN"));
					jsonobject.put("title", rs.getString("Title"));
					jsonobject.put("author", rs.getString("Author"));
					jsonobject.put("publicationYear", rs.getInt("PublicationYear"));
					jsonobject.put(" genre", rs.getString("Genre"));
					jsonobject.put("availableCopies", rs.getInt("AvailableCopies"));
					jsonobject.put("totalCopies", rs.getInt("TotalCopies"));

					jsonArray.add(jsonobject);

					res.setData("Books Data Fetched Successfully!");
					res.setResponseCode(200);
					res.setResponseMessage("Success");
                    res.setjData(jsonArray);
				}

			} catch (Exception e) {
				e.printStackTrace();

				res.setData("Cannot Fetch Books!");
				res.setResponseCode(500);
				res.setResponseMessage("Error");

			}

		} catch (Exception e) {
			e.printStackTrace();

			res.setData("Driver Class Error!");
			res.setResponseCode(500);
			res.setResponseMessage("Error");

		}

		return res;
	}

	@SuppressWarnings("unchecked")
	public Response getOneUser(String MemberID) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String selectQuery = "select * from librarymembers where MemberID = '" + MemberID + "'";

			JSONObject jsonObject = new JSONObject();

			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(selectQuery);) {

				while (rs.next()) {

					jsonObject.put("memberID", rs.getString("MemberID"));
					jsonObject.put("firstName", rs.getString("FirstName"));
					jsonObject.put("lastName", rs.getString("LastName"));
					jsonObject.put("dob", rs.getDate("DateOfBirth"));
					jsonObject.put("address", rs.getString("Address"));
					jsonObject.put("email", rs.getString("Email"));
					jsonObject.put("phoneNumber", rs.getLong("PhoneNumber"));
					jsonObject.put("createdBy", rs.getLong("created_by"));
					jsonObject.put("updateBy", rs.getLong("updated_by"));
					jsonObject.put("createdTime", rs.getLong("created_time"));
					jsonObject.put("updatedTime", rs.getLong("updated_time"));
					jsonObject.put("password", rs.getLong("password"));

					res.setData("User Fetched Successfully!");
					res.setResponseCode(200);
					res.setResponseMessage("Success");
					res.setjData(jsonObject);

				}

			} catch (Exception e) {

				e.printStackTrace();

				res.setData("Cannot Fetch User!");
				res.setResponseCode(500);
				res.setResponseMessage("Error");

			}

		} catch (Exception e) {

			e.printStackTrace();

			res.setData("Driver Class Error!");
			res.setResponseCode(500);
			res.setResponseMessage("Error");

		}
		return res;
	}

	@SuppressWarnings("unchecked")
	public Response getOneBook(String ISBN) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String selectQuery = "select * from librarybooks where ISBN = '" + ISBN + "'";

			JSONObject jsonObject = new JSONObject();

			try (Connection conn = DriverManager.getConnection(url, username, password);
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(selectQuery);) {

				while (rs.next()) {

					jsonObject.put("isbn", rs.getString("ISBN"));
					jsonObject.put("title", rs.getString("Title"));
					jsonObject.put("author", rs.getString("Author"));
					jsonObject.put("publicationYear", rs.getInt("PublicationYear"));
					jsonObject.put(" genre", rs.getString("Genre"));
					jsonObject.put("availableCopies", rs.getInt("AvailableCopies"));
					jsonObject.put("totalCopies", rs.getInt("TotalCopies"));

					res.setData("Book Fetched Successfully!");
					res.setResponseCode(200);
					res.setResponseMessage("Success");
					res.setjData(jsonObject);

				}

			} catch (Exception e) {

				e.printStackTrace();

				res.setData("Cannot Fetch User!");
				res.setResponseCode(500);
				res.setResponseMessage("Error");

			}

		} catch (Exception e) {

			e.printStackTrace();

			res.setData("Driver Class Error!");
			res.setResponseCode(500);
			res.setResponseMessage("Error");

		}

		return res;
	}

}
