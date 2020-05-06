package tech.thdev.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tech.thdev.base.presenter.BasePresenter
import tech.thdev.base.presenter.BaseView

abstract class BasePresenterFragment<in VIEW : BaseView, PRESENTER : BasePresenter<VIEW>> :
    BaseFragment(), BaseView {

    protected lateinit var presenter: PRESENTER
        private set

    abstract fun onCreatePresenter(): PRESENTER

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = onCreatePresenter()
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter.attachView(this as VIEW)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}