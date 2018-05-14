package pl.coderslab.servlets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_01")
public class Servlet_02 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Path filePath = Paths.get("/home/tj/workspace/Homework_01/src/pl/coderslab/servlets/oop.txt");
				System.out.println(filePath.getRoot());;
	try {
		for (String string : Files.readAllLines(filePath)) {
				resp.getWriter().append("<h1>").append(string).append("</h1>");
				
			}
	} catch (NoSuchFileException e) {
		resp.getWriter().append("<h1>").append("Brak pliku").append("</h1>");

	}
	}

}
// #### Zadanie 2
//
// W projekcie stwórz servlet `Servlet_02`, dostępny pod adresem
// **/Servlet_01**,
// Servlet wczyta zawartość pliku oop.txt, a następnie wyświetli jego zawartość
// na stronie. Jest to lista języków programowania, które wzorują się na
// [paradygmacie obiektowym][oop-paradygmat] pobrana z [Wikipedii][oop-wiki].
