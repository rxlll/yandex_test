package suhockii.dev.translator.ui.pager.favorites;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import suhockii.dev.translator.App;
import suhockii.dev.translator.business.client.ClientInteractor;
import suhockii.dev.translator.data.repositories.database.Translation;

/**
 * Created by Maksim Sukhotski on 4/17/2017.
 */

@InjectViewState
public class FavoritesPresenter extends MvpPresenter<FavoritesView> {
    public static final boolean FAVORITES = true;
    @Inject
    ClientInteractor clientInteractor;

    public FavoritesPresenter() {
        App.appComponent.inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        clientInteractor.getTranslations(FAVORITES)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(translations -> getViewState().showTranslations(translations));
    }

    public void updateTranslation(Translation translation) {
        clientInteractor.putTranslationFavorite(translation)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }
}
