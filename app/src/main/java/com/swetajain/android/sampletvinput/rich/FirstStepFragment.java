
package com.swetajain.android.sampletvinput.rich;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v17.leanback.app.GuidedStepFragment;
import android.support.v17.leanback.widget.GuidanceStylist.Guidance;
import android.support.v17.leanback.widget.GuidedAction;
import com.swetajain.android.sampletvinput.R;
import java.util.List;

/** Introduction step in the input setup flow. */
public class FirstStepFragment extends GuidedStepFragment {

    @Override
    @NonNull
    public Guidance onCreateGuidance(@NonNull Bundle savedInstanceState) {
        String title = getString(R.string.rich_input_label);

        String description = getString(R.string.rich_setup_first_step_description);
        Drawable icon = getActivity().getDrawable(R.drawable.android_48dp);
        return new Guidance(title, description, null, icon);
    }

    @Override
    public void onCreateActions(@NonNull List<GuidedAction> actions, Bundle savedInstanceState) {
        actions.add(
                new GuidedAction.Builder(getContext())
                        .id(GuidedAction.ACTION_ID_NEXT)
                        .title(R.string.rich_setup_add_channel)
                        .hasNext(true)
                        .build());
        actions.add(
                new GuidedAction.Builder(getContext())
                        .id(GuidedAction.ACTION_ID_CANCEL)
                        .title(R.string.rich_setup_cancel)
                        .build());
        //TODO add about screen
    }

    @Override
    public void onGuidedActionClicked(GuidedAction action) {
        if (action.getId() == GuidedAction.ACTION_ID_NEXT) {
            GuidedStepFragment.add(getFragmentManager(), new RichSetupFragment());
        } else if (action.getId() == GuidedAction.ACTION_ID_CANCEL) {
            getActivity().setResult(Activity.RESULT_CANCELED);
            getActivity().finishAfterTransition();
        }
    }
}
