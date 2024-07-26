package com.soten.test.jguen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor() : ViewModel() {

    private val _personsLiveData = MutableLiveData<MyStack<Person>>(MyStack())
    private val personsLiveData get() = _personsLiveData

    private val _oldPersonLiveData = MutableLiveData<Person>()
    val oldPersonLiveData get() = _oldPersonLiveData

    private val _youngPersonLiveData = MutableLiveData<Person>()
    val youngPersonLiveData get() = _youngPersonLiveData

    fun addPerson(person: Person) {
        _personsLiveData.value = personsLiveData.value.apply {
            this?.push(person)
        }

        viewModelScope.launch {

        }
    }

    private fun updateOldestPerson(person: Person) {
        val oldPerson = _oldPersonLiveData.value
        if (oldPerson == null || oldPerson.age < person.age) {
            _oldPersonLiveData.value = person
        }
    }

    private fun updateYoungestPerson(person: Person) {
        val youngPerson = _youngPersonLiveData.value
        if (youngPerson == null || youngPerson.age > person.age) {
            _youngPersonLiveData.value = person
        }
    }
}