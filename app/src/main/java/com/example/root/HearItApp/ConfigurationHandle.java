package com.example.root.HearItApp;

import android.os.Handler;
import android.os.Message;

/**
 * Created by root on 12/11/16.
 */

public class ConfigurationHandle extends Handler {
    public static final int	MSG_WHAT_SEND_CONFIG	= 1;

    private GlassUpAgentVersionSupport agent;

    public ConfigurationHandle(GlassUpAgentVersionSupport agent){
        this.agent = agent;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if (msg.what == MSG_WHAT_SEND_CONFIG) {
            removeMessages(MSG_WHAT_SEND_CONFIG);

            if (!agent.isConfigured() && agent.isConnected()) {
                agent.sendConfigure(new int[]{R.drawable.ic_launcher});

            }
            sendEmptyMessageDelayed(MSG_WHAT_SEND_CONFIG, 10000);

        }
    }
}
