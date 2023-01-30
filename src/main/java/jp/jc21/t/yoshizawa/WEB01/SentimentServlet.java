package jp.jc21.t.yoshizawa.WEB01;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/sentimentresult")
public class SentimentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SentimentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String string = "生姜焼定食";
		try {
			Senti result = Sentiment.getSentiment(string);
			double message = result.documents[0].confidenceScores.positive;
			request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-INF/jsp/sentimentresult.jsp").forward(request, response);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String string = request.getParameter("string");
		request.setAttribute("string", string);

		try {
			Senti result = Sentiment.getSentiment(string);
			double message = result.documents[0].confidenceScores.positive;
			double message1 = result.documents[0].confidenceScores.neutral;
			double message2 = result.documents[0].confidenceScores.negative;
			request.setAttribute("message", message);
			request.setAttribute("message1", message1);
			request.setAttribute("message2", message2);
			request.getRequestDispatcher("/WEB-INF/jsp/sentimentresult.jsp").forward(request, response);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
