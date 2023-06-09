package dev.prem.newbudgetwidget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.prem.newbudgetwidget.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var listItems = ArrayList<String>(2)
        listItems.add("First")
        listItems.add("Second")
        _binding = FragmentFirstBinding.inflate(inflater, container, false).apply {
            composeView.setContent {
                // You're in Compose world!
                MaterialTheme {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        Text(
                            text = "Today",
                            color = colorResource(R.color.textColor),
                            textAlign = TextAlign.Center,
                        )
                        Card(
                            backgroundColor = colorResource(R.color.cardBackground),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "411.73 left",
                                    color = colorResource(R.color.textColor),
                                    fontSize = 22.sp
                                )
                                Text(
                                    text = "411.73 limit",
                                    color = colorResource(R.color.textColor),
                                    fontSize = 22.sp
                                )
                            }
                        }
                        Text(
                            text = "Month",
                            color = colorResource(R.color.textColor),
                            textAlign = TextAlign.Center
                        )
                        Card(
                            backgroundColor = colorResource(R.color.cardBackground),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 12.dp)
                                    .wrapContentWidth(Alignment.CenterHorizontally)
                            ) {
                                Text(
                                    text = "Limit 12789, Left: 8234",
                                    color = colorResource(R.color.textColor),
                                    fontSize = 18.sp
                                )
                                IconButton(onClick = { }) {
                                    Icon(
                                        imageVector = Icons.Default.Edit,
                                        contentDescription = "Edit",
                                        modifier = Modifier.size(20.dp),
                                        tint = colorResource(R.color.textColor)
                                    )
                                }
                            }
                        }
                        Text(
                            text = "Expenses",
                            color = colorResource(R.color.textColor),
                            textAlign = TextAlign.Center
                        )
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            items(listItems) { item ->
                                Card(
                                    backgroundColor = colorResource(R.color.cardBackground),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(35.dp)
                                            .padding(8.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier.fillMaxHeight(),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = item,
                                                color = colorResource(id = R.color.textColor),
                                                textAlign = TextAlign.Center
                                            )
                                        }
                                        IconButton(onClick = {
                                            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Edit,
                                                contentDescription = "Edit",
                                                modifier = Modifier.size(15.dp),
                                                tint = colorResource(R.color.textColor)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}