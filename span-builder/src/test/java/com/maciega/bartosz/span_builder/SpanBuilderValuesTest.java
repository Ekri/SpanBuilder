package com.maciega.bartosz.span_builder;

import android.text.Spanned;
import android.widget.TextView;


import com.maciega.bartosz.spanbuilder.spans.SpanBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Created by bartoszmaciega on 14/03/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class SpanBuilderValuesTest {

    private SpanBuilder spanBuilder;
    private String text = "Simple to test text";
    @Mock
    TextView textView;

    @Rule
    public ExpectedException exception = ExpectedException.none();


    @Before
    public void setUp() {
        spanBuilder = SpanBuilder.newInstance(text);
    }

    @Test
    public void testInitialValues() {
        assertEquals(spanBuilder.getText(), text);
        assertEquals(spanBuilder.getStartIndex(), 0);
        assertEquals(spanBuilder.getEndIndex(), text.length());
        assertEquals(spanBuilder.getFlags(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        assertNotNull(spanBuilder.build());
        assertNull(spanBuilder.getTextView());
    }

    @Test
    public void testChangeIndexes() {
        spanBuilder.index(0, 11);
        assertEquals(spanBuilder.getStartIndex(), 0);
        assertEquals(spanBuilder.getEndIndex(), 11);
        spanBuilder.index(11, 12);
        assertEquals(spanBuilder.getStartIndex(), 11);
        assertEquals(spanBuilder.getEndIndex(), 12);
        spanBuilder.resetIndex();
        assertEquals(spanBuilder.getStartIndex(), 0);
        assertEquals(spanBuilder.getEndIndex(), text.length());
    }

    @Test
    public void testInvalidIndex() {
        exception.expect(IllegalArgumentException.class);
        spanBuilder.index(20, 8);
    }

    @Test
    public void testChangeFlags() {
        spanBuilder.withFlag(Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        assertEquals(spanBuilder.getFlags(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spanBuilder.withFlag(Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        assertEquals(spanBuilder.getFlags(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spanBuilder.resetFlags();
        assertEquals(spanBuilder.getFlags(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
    }

    @Test
    public void testTextView() {
        spanBuilder.withView(textView);
        assertNotNull(spanBuilder.getTextView());
        spanBuilder.buildWithTextView();
//        assertEquals(textView.getText(), text);
    }


    @After
    public void clear() {
        spanBuilder.resetIndex();
        spanBuilder.resetFlags();
    }

}
