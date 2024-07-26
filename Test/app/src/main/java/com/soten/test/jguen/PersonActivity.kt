package com.soten.test.jguen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.soten.test.databinding.ActivityPersonBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonActivity : AppCompatActivity() {

    private val binding by lazy { ActivityPersonBinding.inflate(layoutInflater) }

    private val personViewModel by viewModels<PersonViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        bindOnPersonInputButton()

        observeData()
    }

    private fun bindOnPersonInputButton() {
        binding.personInputButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val age = binding.ageEditText.text.toString().toIntOrNull()

            if (name.isBlank() || age == null) {
                Toast.makeText(applicationContext, "이름과 나이를 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            personViewModel.addPerson(Person(name, age))

            binding.nameEditText.text.clear()
            binding.ageEditText.text.clear()
        }
    }

    private fun observeData() {
        personViewModel.oldPersonLiveData.observe(this) { person ->
            binding.oldestPersonNameTextView.text = person.name
            binding.oldestPersonAgeTextView.text = person.age.toString()
        }

        personViewModel.youngPersonLiveData.observe(this) { person ->
            binding.youngestPersonNameTextView.text = person.name
            binding.youngestPersonAgeTextView.text = person.age.toString()
        }
    }
}