package package_Pragma;

public class Deliveries_attrib {
	

	int match_id, inning, over, ball, wide_runs, bye_runs, legby_runs, noball_runs;
	int penalty_runs, batsman_runs, extra_runs, total_runs;
	String batting_team, bowling_team, batsman, bowler;
	
	public Deliveries_attrib()
	{
		match_id = 0;    //0
		inning = 0;
		over = 0;
		ball = 0;
		wide_runs = 0;
		bye_runs = 0;
		legby_runs= 0;
		noball_runs = 0;
		penalty_runs = 0;
		extra_runs = 0;
		batsman_runs = 0;
		total_runs = 0;
		
		batting_team = "";
		bowling_team="";
		batsman="";
		bowler = "";
	}
	
	

	public Deliveries_attrib(int match_id, int inning, String batting_team, String bowling_team,
			int over, int ball, String batsman, String bowler, int wide_runs, int bye_runs, int legby_runs,
			int noball_runs, int penalty_runs, int batsman_runs, int extra_runs, int total_runs
			) {
		this.match_id = match_id;
		this.inning = inning;
		this.over = over;
		this.ball = ball;
		this.wide_runs = wide_runs;
		this.bye_runs = bye_runs;
		this.legby_runs = legby_runs;
		this.noball_runs = noball_runs;
		this.penalty_runs = penalty_runs;
		this.batsman_runs = batsman_runs;
		this.extra_runs = extra_runs;
		this.total_runs = total_runs;
		
		this.batting_team = batting_team;
		this.bowling_team = bowling_team;
		this.batsman = batsman;
		this.bowler = bowler;
	}



	public int getMatch_id() {
		return match_id;
	}

	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}
	
	public int getInning() {
		return inning;
	}

	public void setInning(int inning) {
		this.inning = inning;
	}

	public int getOver() {
		return over;
	}

	public void setOver(int over) {
		this.over = over;
	}

	public int getBall() {
		return ball;
	}

	public void setBall(int ball) {
		this.ball = ball;
	}

	public int getWide_runs() {
		return wide_runs;
	}

	public void setWide_runs(int wide_runs) {
		this.wide_runs = wide_runs;
	}

	public int getBye_runs() {
		return bye_runs;
	}

	public void setBye_runs(int bye_runs) {
		this.bye_runs = bye_runs;
	}

	public int getLegby_runs() {
		return legby_runs;
	}

	public void setLegby_runs(int legby_runs) {
		this.legby_runs = legby_runs;
	}

	public int getNoball_runs() {
		return noball_runs;
	}

	public void setNoball_runs(int noball_runs) {
		this.noball_runs = noball_runs;
	}

	public int getPenalty_runs() {
		return penalty_runs;
	}

	public void setPenalty_runs(int penalty_runs) {
		this.penalty_runs = penalty_runs;
	}

	public int getTotal_runs() {
		return total_runs;
	}

	public void setTotal_runs(int total_runs) {
		this.total_runs = total_runs;
	}

	public int getBatsman_runs() {
		return batsman_runs;
	}

	public void setBatsman_runs(int batsman_runs) {
		this.batsman_runs = batsman_runs;
	}

	public int getExtra_runs() {
		return extra_runs;
	}

	public void setExtra_runs(int extra_runs) {
		this.extra_runs = extra_runs;
	}

	public String getBatting_team() {
		return batting_team;
	}

	public void setBatting_team(String batting_team) {
		this.batting_team = batting_team;
	}

	public String getBowling_team() {
		return bowling_team;
	}

	public void setBowling_team(String bowling_team) {
		this.bowling_team = bowling_team;
	}

	public String getBatsman() {
		return batsman;
	}

	public void setBatsman(String batsman) {
		this.batsman = batsman;
	}

	public String getBowler() {
		return bowler;
	}

	public void setBowler(String bowler) {
		this.bowler = bowler;
	}
	
	@Override
	public String toString() {
		return String.format("MATCH_ID=%d, INNING =%d, BATTING_TEAM =%s, BOWLING_TEAM =%s,OVER =%d, BALL= %d, BATSMAN= %s, BOWLER= %s, WIDE_RUNS=%d, BYE_RUNS=%d, LEGBYE_RUNS=%d, NOBALL_RUNS=%d, PENALTY_RUNS=%d, BATSMAN_RUNS=%d, EXTRA_RUNS=%d, TOTAL_RUNS=%d",match_id, inning, batting_team,bowling_team,over, ball, batsman, bowler, wide_runs, bye_runs, legby_runs, noball_runs,penalty_runs, batsman_runs, extra_runs, total_runs );
	}
	
}
