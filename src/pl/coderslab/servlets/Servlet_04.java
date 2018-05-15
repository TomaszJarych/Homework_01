package pl.coderslab.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_04")
public class Servlet_04 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String htmlStart = "<html>\n" + "<head>\n" + "<meta charset=\"UTF-8\">\n" + "<title>Losowanie liczb</title>\n"
				+ "</head>\n" + "<body>\n" + "<table>";
		String htmlEnd = "</table>\n" + "</body>\n" + "</html>";
		int[] randNumber = new int[10];
		Random r = new Random();
		for (int i = 0; i < randNumber.length; i++) {
			randNumber[i] = r.nextInt(100) + 1;
		}
		resp.getWriter().append(htmlStart).append("<tr><th>Liczby wylosowane</th>")
				.append("<td>" + Arrays.toString(randNumber) + "</td>").append("</tr>");
		Arrays.sort(randNumber);
		resp.getWriter().append(htmlStart).append("<tr><th>Liczby wylosowane-posortowane</th>")
				.append("<td>" + Arrays.toString(randNumber) + "</td>").append("</tr>").append(htmlEnd);

	}

}
// #### Zadanie 4
//
// W projekcie stwórz servlet `Servlet_04`, który wylosuje 10 liczb z zakresu
// 1-100. Następnie Wyświetl dwie tabelki z tymi liczbami:
// 1. Pierwsza tabelka powinna wyświetlić wartości w kolejności jakiej zostały
// wylosowane.
// 2. Druga tabelka powinna wyświetlać wartości posortowane (od najmniejszej do
// największej).