package com.imobile3.groovypayments.ui.chart;

import com.imobile3.groovypayments.data.CartRepository;
import com.imobile3.groovypayments.data.TestDataRepository;
import com.imobile3.groovypayments.data.entities.CartEntity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class PieChartViewModel extends ViewModel {

    private CartRepository mCartRepository;

    PieChartViewModel(CartRepository repository) {
        mCartRepository = repository;
    }

    LiveData<List<CartEntity>> getProductList() {
        final MutableLiveData<List<CartEntity>> observable =
                new MutableLiveData<>(new ArrayList<>());
        List<CartEntity> cartEntities = TestDataRepository.getInstance()
                .getCarts(TestDataRepository.Environment.GroovyDemo);
        observable.postValue(cartEntities);
        return observable;
    }
}
