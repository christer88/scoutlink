package uk.org.mattford.scoutlink.receiver;

import uk.org.mattford.scoutlink.activity.ConversationsActivity;
import uk.org.mattford.scoutlink.model.Broadcast;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ConversationReceiver extends BroadcastReceiver {
	
	private ConversationsActivity activity;
	
	public ConversationReceiver(ConversationsActivity act) {
		super();
		this.activity = act;
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		if (action.equals(Broadcast.NEW_CONVERSATION)) {
			activity.onNewConversation(intent.getStringExtra("target"));
		} else if (action.equals(Broadcast.NEW_MESSAGE)) {
			activity.onConversationMessage(intent.getStringExtra("target"));
		} else if (action.equals(Broadcast.REMOVE_CONVERSATION)){
			activity.removeConversation(intent.getStringExtra("target"));
		} else if (action.equals(Broadcast.INVITE)) {
			activity.onInvite(intent.getStringExtra("target"));
		} else if (action.equals(Broadcast.DISCONNECTED)) {
			activity.onDisconnect();
		}
		
	}

}
