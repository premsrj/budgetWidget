package dev.prem.newbudgetwidget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.prem.newbudgetwidget.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false).apply {
            composeView.setContent {

                MaterialTheme {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        Text(
                            text = "15 May 2024 4:07 PM",
                            color = colorResource(R.color.textColor),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(10.dp)
                        )
                        AmountField()
                        DescriptionField()
                        Button(onClick = {
                            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
                        },
                            modifier = Modifier.size(80.dp),
                            shape = RoundedCornerShape(80.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Done,
                                contentDescription = "Edit",
                                modifier = Modifier.size(45.dp),
                                tint = colorResource(R.color.textColor)
                            )
                        }
                    }

                }
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val floatingButton = (activity as MainActivity?)!!.getFloatingActionButton()
        floatingButton.hide()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @Composable
    fun AmountField() {

        var text by remember { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = { Text("Amount",
                color = colorResource(R.color.textColor)) },
            modifier = Modifier.padding(10.dp),
            colors = TextFieldDefaults.textFieldColors(textColor = colorResource(R.color.textColor))
        )
    }
    @Composable
    fun DescriptionField() {

        var text by remember { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = { Text(
                "Description",
                color = colorResource(R.color.textColor),
            ) },
            modifier = Modifier.padding(10.dp),
            colors = TextFieldDefaults.textFieldColors(textColor = colorResource(R.color.textColor))
        )
    }
}