package pl.coderslab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_03_2")
public class Servlet_03_2 extends HttpServlet {
	String products[] = { "Asus Transformr;2999.99", "iPhone 6';3499.18", "Converse Sneakers;125.00",
			"LG OLED55B6P OLED TV;6493.91", "Samsung HT-J4100;800.99", "Alpine Swiss Dress Belt;99.08",
			"60 Watt LED;1.50", "Arduino Nano;3.26", };

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String[] product;
		try {
			product = products[id].split(";");
			resp.getWriter().append("<h1>").append(product[0]+" - "+product[1]).append("</h1>");
		} catch (IndexOutOfBoundsException e) {
			resp.getWriter().append("<h1>").append("Product not found").append("</h1>");
		}
	}

}
// #### Zadanie 3
//
// W projekcie stwórz servlety `Servlet_03_1`, `Servlet_03_2`, dostępne
// odpowiednio pod adresami
// **/Servlet_03_1**, **/Servlet_03_2**.
// Dopisz następującą funkcjonalność:
// * Na pierwszej stronie (`Servlet_03_1`) wygeneruj linki do strony
// `Servlet_03_2`, które będą przesyłały metodą GET id szukanego produktu
// (wygeneruj dla id z zakresu od `0` do `7`).
// * Druga strona (`Servlet_03_2`) po odebraniu danych powinna odnaleźć w
// przygotowanej tablicy produkt (zakładamy że id kolejny element). Poniżej
// znajduje się przykładowa tablica z produktami:
// ```java
// String products[] = {
// "Asus Transformr;2999.99",
// "iPhone 6';3499.18",
// "Converse Sneakers;125.00",
// "LG OLED55B6P OLED TV;6493.91",
// "Samsung HT-J4100;800.99",
// "Alpine Swiss Dress Belt;99.08",
// "60 Watt LED;1.50",
// "Arduino Nano;3.26",
// };
// ```
// * Jeśli produkt znajduje się w tablicy powinna zostać wyświetlona jego nazwa
// i cena np.`Asus Transformer - 2999.99zł`
// * Jeśli wybierzemy produkt spoza zakresu powinien zostać wyświetlony
// komunikat `Product not found.`
//