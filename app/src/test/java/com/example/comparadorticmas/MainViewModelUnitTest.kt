package com.example.comparadorticmas

import com.example.comparadorticmas.view.MainViewModel
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {
        private lateinit var viewModel: MainViewModel

        @get:Rule
        val instantTaskRule = InstantTaskExecutorRule()
        private val dispatcher = StandardTestDispatcher()

        @Before
        fun setup() {
            Dispatchers.setMain(dispatcher)
            viewModel = MainViewModel()
        }

        @After
        fun tearDown() {
            Dispatchers.resetMain()
        }

        @Test
        fun mainViewModel_CheckInitialValue() = runTest {
            val value = viewModel.compare.value?.text1
            Assert.assertEquals("¿Son iguales?", value)
        }
}