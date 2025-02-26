package day0207;

import day0205.Fly;

public class FlyImpl implements Fly {

	@Override
	public String lift() {
		return "양력";
	}

	@Override
	public String thrust() {
		return "추진력";
	}

}
