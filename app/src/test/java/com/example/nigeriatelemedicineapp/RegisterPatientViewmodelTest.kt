package com.example.nigeriatelemedicineapp

import com.example.nigeriatelemedicineapp.registerpatient.RegisterPatientViewModel
import com.example.nigeriatelemedicineapp.repository.Repository
import io.mockk.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class RegisterPatientViewModelTest {

    internal var SPACE_STRING = "      "
    internal var EMPTY_STRING = ""

    lateinit var repo : Repository
    lateinit var viewModel : RegisterPatientViewModel

    @Before
    fun setup(){
        repo = mockk<Repository>()
        every { repo.getIdentifier() } returns null
        viewModel= RegisterPatientViewModel(repo)
    }

    @Test
    fun shouldNotRegisterPatient_when_firstnameIsNull() {
        viewModel.registerPatient(SPACE_STRING, EMPTY_STRING)
        verify(exactly =0){
            repo.getIdentifier()
        }
    }

    @Test
    fun shouldRegisterPatient_when_firstnameIsNotNull() {
        viewModel.registerPatient("test",EMPTY_STRING)
        verify(exactly =1){
            repo.getIdentifier()
        }
    }
}

