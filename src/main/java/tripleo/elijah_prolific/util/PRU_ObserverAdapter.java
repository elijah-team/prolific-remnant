package tripleo.elijah_prolific.util;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Just override onNext
 *
 * @param <T>
 */
public abstract class PRU_ObserverAdapter<T> implements Observer<T> {
	@Override
	public void onSubscribe(@NonNull final Disposable d) {

	}

	@Override
	public void onError(@NonNull final Throwable e) {

	}

	@Override
	public void onComplete() {

	}

	@Override
	public abstract void onNext(@NonNull final T aT);
}
