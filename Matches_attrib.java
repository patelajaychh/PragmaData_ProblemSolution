package package_Pragma;

public class Matches_attrib {
	
	int match_id, season;
	String city, date, team1, team2, toss_winner, toss_decision, result, winner;
	
	public Matches_attrib(int match_id, int season, String city, String date, String team1, String team2,
			String toss_winner, String toss_decision, String result, String winner) 
	{
		this.match_id = match_id;
		this.season = season;
		this.city = city;
		this.date = date;
		this.team1 = team1;
		this.team2 = team2;
		this.toss_winner = toss_winner;
		this.toss_decision = toss_decision;
		this.result = result;
		this.winner = winner;
	}

	public Matches_attrib() 
	{
		
	}

	public int getMatch_id() {
		return match_id;
	}

	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public String getToss_winner() {
		return toss_winner;
	}

	public void setToss_winner(String toss_winner) {
		this.toss_winner = toss_winner;
	}

	public String getToss_decision() {
		return toss_decision;
	}

	public void setToss_decision(String toss_decision) {
		this.toss_decision = toss_decision;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	@Override
	public String toString() {
		return String.format("Match_Id=%d, Season=%d, City=%s, DATE=%s, TEAM1=%s, TEAM2=%s, Toss_winner=%s, Toss_decision=%s, Result=%s, Winner=%s", match_id, season, city, date, team1, team2, toss_winner, toss_decision, result, winner);
	}
	
}
