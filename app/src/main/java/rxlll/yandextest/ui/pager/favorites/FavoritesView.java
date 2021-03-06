package rxlll.yandextest.ui.pager.favorites;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import rxlll.yandextest.data.repositories.database.Translation;

/**
 * Created by Maksim Sukhotski on 4/17/2017.
 */

@StateStrategyType(AddToEndSingleStrategy.class)
public interface FavoritesView extends MvpView {
    void showTranslations(List<Translation> translations);

    void updateTranslationsWith(Translation translation);

    void updateRecyclerWith(String s);
}
