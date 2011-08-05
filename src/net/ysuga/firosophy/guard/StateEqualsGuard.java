package net.ysuga.firosophy.guard;

import net.ysuga.firosophy.FIROSOPHY;
import net.ysuga.rtsbuilder.RTSystemBuilder;

import net.ysuga.rtsbuilder.RTCCondition;
import net.ysuga.statemachine.guard.AbstractGuard;
import net.ysuga.statemachine.guard.GuardParameterMap;
import net.ysuga.statemachine.state.State;

public class StateEqualsGuard extends AbstractGuard {
 
	static final String PATHURI = "pathUri";
	static final String RTCCONDITION = "RTCCondition";
	private String pathUri;
	private RTCCondition rtcCondition;
	 
	/**
	 * <div lang="ja">
	 * @param state
	 * @return
	 * @throws Exception
	 * </div>
	 * <div lang="en">
	 * @param state
	 * @return
	 * @throws Exception
	 * </div>
	 */
	public boolean operate(State state) throws Exception {
		RTCCondition currentCondition = RTSystemBuilder.getComponentCondition(pathUri);
		return currentCondition.equals(rtcCondition);
	}
	
	/**
	 * <div lang="ja">
	 * コンストラクタ
	 * @param name
	 * @param componentPathUri
	 * @param stateCondition
	 * </div>
	 * <div lang="en">
	 * Constructor
	 * @param name
	 * @param componentPathUri
	 * @param stateCondition
	 * </div>
	 */
	public StateEqualsGuard(String name, String componentPathUri, RTCCondition stateCondition) {
		super(name, FIROSOPHY.STATE_EQUALS);
		this.pathUri = componentPathUri;
		this.rtcCondition = stateCondition;
	}

	/**
	 * <div lang="ja">
	 * @return
	 * </div>
	 * <div lang="en">
	 * @return
	 * </div>
	 */
	@Override
	public GuardParameterMap getParameterMap() {
		GuardParameterMap map = new GuardParameterMap();
		map.put(PATHURI, pathUri);
		map.put(RTCCONDITION, rtcCondition.toString());
		return null;
	}
	 
}
 
