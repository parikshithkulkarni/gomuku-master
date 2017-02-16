package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.five.beans.Game;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GameController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Game game = new Game();
	int ind = 0;
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		try {
			getWinner(request, response);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void getWinner(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
		// TODO Auto-generated method stub
		int i, j, size = 19, cellValue;
		int checkStatus =0;
		HttpSession session = request.getSession();
		
		System.out.println("I'm here!");
		
		String cell = request.getParameter("objarray");
		
		
		cellValue = Integer.parseInt(cell);
		
		i = cellValue / size;
		j = cellValue % size;
		if(session.getAttribute("user").toString().equalsIgnoreCase("Parikshith")){
			game.getArray()[i][j] = 1;
		}else if(session.getAttribute("user").toString().equalsIgnoreCase("Amulya")){
			game.getArray()[i][j] = 2;
		}
		
		game.setArray(game.getArray());
		game.getPlayerList()[cellValue] = (String) session.getAttribute("user");
		game.setPlayerList(game.getPlayerList());
		
		String values = "{input:[{";
		for (i = 0; i < size; i++) {
			for (j = 0; j < size; j++) {
				if(game.getArray()[i][j]!=0){
					
					int t = (i*size)+j;
					System.out.println(t);
					if(values.equalsIgnoreCase("{input:[{"))
						values =values+t+game.getPlayerList()[t] +":" +t;
					else
						values =values+","+t+game.getPlayerList()[t] +":" +t;
					System.out.println(values);
				}
			}
		}
		values+="}]}";
		//JsonObject obj = new JsonParser().parse(values).getAsJsonObject();
		JSONObject obj = new JSONObject(values);
		JSONArray arr = obj.getJSONArray("input");
		
		
		for (i = 0; i < size; i++) {
			for (j = 0; j < size; j++) {
				System.out.print(game.getArray()[i][j] + " ");
			}
			System.out.println("");
		}
		
		i = cellValue / size;
		j = cellValue % size;
		
		if (count(game.getArray()[i][j], i, j, 1, 0) >= 5)
			checkStatus = 1;
		else if (count(game.getArray()[i][j], i, j, 0, 1) >= 5)
			checkStatus = 1;
		else if (count(game.getArray()[i][j], i, j, 1, -1) >= 5)
			checkStatus = 1;
		else if (count(game.getArray()[i][j], i, j, 1, 1) >= 5)
			checkStatus = 1;
		else
			checkStatus = 0;
		RequestDispatcher rd = null;
		if(checkStatus==1)
		{
			 rd=request.getRequestDispatcher("jsp/winner.jsp");
								   	
			try {
				response.sendRedirect("jsp/winner.jsp");
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}/*else{
			rd=request.getRequestDispatcher("jsp/winner.jsp");
			response.sendRedirect("jsp/winner.jsp");
		}*/
		if(checkStatus==0){
			PrintWriter out = response.getWriter();
			out.println(arr);
			out.close();
		}
	}

	private int count(int move, int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		int ct = 1; // Number of pieces in a row belonging to the player.
		int r, c; // A row and column to be examined
		r = i + k; // Look at square in specified direction.
		c = j + l;
		int[][] board = new int[19][19];
		while (r >= 0 && r < 13 && c >= 0 && c < 13 && game.getArray()[r][c] == move) {
			// Square is on the board and contains one of the players's pieces.
			ct++;
			r += k; // Go on to next square in this direction.
			c += l;
		}
		r = i - k; // Look in the opposite direction.
		c = j - l;
		while (r >= 0 && r < 13 && c >= 0 && c < 13 && game.getArray()[r][c] == move) {
			// Square is on the board and contains one of the players's pieces.
			ct++;
			r -= k; // Go on to next square in this direction.
			c -= l;
		}
		return ct;
	}

}
