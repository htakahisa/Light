package knowledge.prime.light;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class LightWidget extends AppWidgetProvider {


    final String btn1Filter = "knowledge.prime.light.BUTTON1_CLICKED";

    private TouchedAction action;

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.light_widget);


        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);


        System.out.println("updateAppWidget");

    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.light_widget);
            Intent btn1Intent = new Intent(btn1Filter);
            PendingIntent btn1Pending = PendingIntent.getBroadcast(context, 0, btn1Intent, 0);
            views.setOnClickPendingIntent(R.id.imageView, btn1Pending);

            appWidgetManager.updateAppWidget(appWidgetIds, views);
        }

//        System.out.println("onUpdate");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        String action = intent.getAction();
        if (action.equals(btn1Filter)) {
            getTouchedAction().execute();
        }
//        System.out.println("onReceive");
    }

    public TouchedAction getTouchedAction() {
        if (action == null) {
            action = new TouchedAction();
        }
        return action;
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
//        System.out.println("onEnabeld");
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
//        System.out.println("onDisabled");
    }
}

