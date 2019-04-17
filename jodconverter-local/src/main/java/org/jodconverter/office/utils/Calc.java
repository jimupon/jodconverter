/*
 * Copyright 2004 - 2012 Mirko Nasato and contributors
 *           2016 - 2018 Simon Braconnier and contributors
 *
 * This file is part of JODConverter - Java OpenDocument Converter.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jodconverter.office.utils;

import com.sun.star.lang.XComponent;
import com.sun.star.sheet.XSpreadsheetDocument;

/**
 * A collection of utility functions to make Office Calc documents (Spreadsheet) easier to use.
 *
 * <p>Inspired by the work of Dr. Andrew Davison from the website <a
 * href="http://fivedots.coe.psu.ac.th/~ad/jlop">Java LibreOffice Programming</a>.
 */
public final class Calc {

  /**
   * Gets whether the given document is a Spreadsheet document.
   *
   * @param document The document to test.
   * @return {@code true} if the document is a Spreadsheet document, {@code false} otherwise.
   */
  public static boolean isCalc(final XComponent document) {
    return Info.isDocumentType(document, Lo.CALC_SERVICE);
  }

  /**
   * Casts the given document into a {@link XSpreadsheetDocument}.
   *
   * @param document The document to cast.
   * @return The {@link XSpreadsheetDocument}, or null if the document is not a Spreadsheet
   *     document.
   */
  public static XSpreadsheetDocument getCalcDoc(final XComponent document) {

    if (document == null) {
      return null;
    }

    return Lo.qi(XSpreadsheetDocument.class, document);
  }

  // Suppresses default constructor, ensuring non-instantiability.
  private Calc() {
    throw new AssertionError("Utility class must not be instantiated");
  }
}
