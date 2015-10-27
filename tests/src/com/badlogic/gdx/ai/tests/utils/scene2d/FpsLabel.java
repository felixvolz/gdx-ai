/*******************************************************************************
 * Copyright 2014 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.badlogic.gdx.ai.tests.utils.scene2d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.StringBuilder;

/** A label showing current FPS.
 * 
 * @author davebaol */
public class FpsLabel extends Label {

	int fps;
	int appendIndex;

	public FpsLabel (CharSequence text, Skin skin) {
		this(text, skin.get(LabelStyle.class));
	}

	public FpsLabel (CharSequence text, Skin skin, String styleName) {
		this(text, skin.get(styleName, LabelStyle.class));
	}

	public FpsLabel (CharSequence text, Skin skin, String fontName, Color color) {
		this(text, new LabelStyle(skin.getFont(fontName), color));
	}

	public FpsLabel (CharSequence text, Skin skin, String fontName, String colorName) {
		this(text, new LabelStyle(skin.getFont(fontName), skin.getColor(colorName)));
	}

	public FpsLabel (CharSequence text, LabelStyle style) {
		super(text, style);
		this.fps = 0;
		this.appendIndex = text.length();
	}

	@Override
	public void act (float delta) {
		if (fps != Gdx.graphics.getFramesPerSecond()) {
			fps = Gdx.graphics.getFramesPerSecond();
			StringBuilder sb = getText();
			sb.setLength(appendIndex);
			sb.append(fps);
			invalidateHierarchy();
		}
		super.act(delta);
	}

}
